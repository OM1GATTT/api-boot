package top.om1ga.rbac.service.impl;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.om1ga.common.utils.PageResult;
import top.om1ga.mybatis.service.impl.BaseServiceImpl;
import top.om1ga.rbac.convert.SysRoleConvert;
import top.om1ga.rbac.dao.SysRoleDao;
import top.om1ga.rbac.entity.SysRoleEntity;
import top.om1ga.rbac.query.SysRoleQuery;
import top.om1ga.rbac.service.SysRoleMenuService;
import top.om1ga.rbac.service.SysRoleService;
import top.om1ga.rbac.service.SysUserRoleService;
import top.om1ga.rbac.vo.SysRoleVO;

import java.util.List;

/**
 * 系统角色服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {
    private final SysRoleMenuService sysRoleMenuService;
    private final SysUserRoleService sysUserRoleService;


    @Override
    public PageResult<SysRoleVO> page(SysRoleQuery query) {
        IPage<SysRoleEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(SysRoleConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private Wrapper<SysRoleEntity> getWrapper(SysRoleQuery query){
        LambdaQueryWrapper<SysRoleEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getName()), SysRoleEntity::getName, query.getName());
        return wrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysRoleVO vo) {
        SysRoleEntity entity = SysRoleConvert.INSTANCE.convert(vo);
        System.out.println(entity);
        baseMapper.insert(entity);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRoleVO vo) {
        SysRoleEntity entity = SysRoleConvert.INSTANCE.convert(vo);
        updateById(entity);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        // 删除角色
        removeById(id);
        // 删除用户角色关系
        sysUserRoleService.deleteByRoleIdList(List.of(id));
        // 删除角色菜单关系
        sysRoleMenuService.deleteByRoleIdList(List.of(id));
    }

    @Override
    public void setRoleMenus(Long roleId, List<Long> menuIds) {
        sysRoleMenuService.saveOrUpdate(roleId, menuIds);
    }

}