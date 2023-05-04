package top.om1ga.rbac.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.om1ga.common.constant.Constant;
import top.om1ga.common.exception.ServerException;
import top.om1ga.common.utils.PageResult;
import top.om1ga.common.utils.TreeUtils;
import top.om1ga.mybatis.service.impl.BaseServiceImpl;
import top.om1ga.rbac.convert.SysMenuConvert;
import top.om1ga.rbac.dao.SysMenuDao;
import top.om1ga.rbac.entity.SysMenuEntity;
import top.om1ga.rbac.enums.SuperAdminEnum;
import top.om1ga.rbac.query.SysMenuQuery;
import top.om1ga.rbac.service.SysMenuService;
import top.om1ga.rbac.service.SysRoleMenuService;
import top.om1ga.rbac.vo.SysMenuVO;
import top.om1ga.security.user.UserDetail;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 菜单管理服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

    private final SysRoleMenuService sysRoleMenuService;

    @Override
    public PageResult<SysMenuVO> page(SysMenuQuery query) {
        LambdaQueryWrapper<SysMenuEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysMenuEntity::getType, query.getType());
        IPage<SysMenuEntity> page = baseMapper.selectPage(getPage(query), wrapper);
        List<SysMenuVO> list = TreeUtils.build(SysMenuConvert.INSTANCE.convertList(page.getRecords()), Constant.ROOT);
        return new PageResult<>(list, page.getTotal());
    }
    @Override
    public Long getSubMenuCount(Long pid) {
        return count(new LambdaQueryWrapper<SysMenuEntity>().eq(SysMenuEntity::getPid, pid));
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysMenuVO vo) {
        SysMenuEntity entity = SysMenuConvert.INSTANCE.convert(vo);
        // 保存菜单
        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysMenuVO vo) {
        SysMenuEntity entity = SysMenuConvert.INSTANCE.convert(vo);
        // 上级菜单不能为自己
        if (entity.getId().equals(entity.getPid())) {
            throw new ServerException("上级菜单不能为自己");
        }
        // 更新菜单
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        // 删除菜单
        removeById(id);
        // 删除角色菜单关系
        sysRoleMenuService.deleteByMenuId(id);
    }

    @Override
    public List<SysMenuVO> getMenuList(Integer type) {
        List<SysMenuEntity> menuList = baseMapper.getMenuList(type);
        return TreeUtils.build(SysMenuConvert.INSTANCE.convertList(menuList), Constant.ROOT);
    }

    @Override
    public List<SysMenuVO> getUserMenuList(UserDetail user, Integer type) {
        List<SysMenuEntity> menuList;
//        系统管理员，拥有最高权限
        if (user.getSuperAdmin().equals(SuperAdminEnum.YES.getValue())) {
            menuList = baseMapper.getMenuList(type);
        } else {
            menuList = baseMapper.getUserMenuList(user.getId(), type);
        }
        List<SysMenuVO> build = TreeUtils.build(SysMenuConvert.INSTANCE.convertList(menuList));
        return build;
    }

    @Override
    public Set<String> getUserAuthority(UserDetail user) {
        List<String> authorityList;
//        系统管理员
        if (user.getSuperAdmin().equals(SuperAdminEnum.YES.getValue())) {
//            赋予所有权限
            authorityList = baseMapper.getAuthorityList();
        } else {
//            查询该用户的所有权限
            authorityList = baseMapper.getUserAuthorityList(user.getId());
        }

//        根据，分割字符串，得到list,去重去空，加入set
        Set<String> permsSet = new HashSet<>();
        for (String authority :
                authorityList) {
            if (StrUtil.isBlank(authority)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(authority.trim().split(",")));
        }
        return permsSet;
    }
}