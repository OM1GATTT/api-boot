package top.om1ga.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.om1ga.common.constant.Constant;
import top.om1ga.common.exception.ServerException;
import top.om1ga.common.utils.PageResult;
import top.om1ga.mybatis.service.impl.BaseServiceImpl;
import top.om1ga.rbac.convert.SysUserConvert;
import top.om1ga.rbac.dao.SysUserDao;
import top.om1ga.rbac.entity.SysUserEntity;
import top.om1ga.rbac.enums.SuperAdminEnum;
import top.om1ga.rbac.query.SysUserQuery;
import top.om1ga.rbac.service.SysUserService;
import top.om1ga.rbac.vo.SysUserVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统用户服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(Long id, String newPassword) {
        // 修改密码
        SysUserEntity user = getById(id);
        user.setPassword(newPassword);
        updateById(user);
    }

    @Override
    public PageResult<SysUserVO> page(SysUserQuery query) {
//        查询参数
        Map<String, Object> params = getParams(query);
//        分页查询
        IPage<SysUserEntity> page = getPage(query);
        params.put(Constant.PAGE,page);
//        获取数据列表
        List<SysUserEntity> list = baseMapper.getList(params);
        return new PageResult<>(SysUserConvert.INSTANCE.convertList(list),page.getTotal());
    }

//    @Override
//    public SysUserEntity getById(Long id) {
//        if (id==null){
//            throw new ServerException("用户id不能为空");
//        }
//        return baseMapper.getById(id);
//    }

    private Map<String,Object> getParams(SysUserQuery query){
        Map<String,Object> params = new HashMap<>();
        params.put("username",query.getUsername());
        params.put("mobile",query.getMobile());
        params.put("gender",query.getGender());
        return params;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysUserVO vo) {
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);
        entity.setSuperAdmin(SuperAdminEnum.NO.getValue());
//        判断用户名是否存在
        SysUserEntity user = baseMapper.getByUsername(entity.getUsername());
        if (user != null){
            throw new ServerException("用户名已经存在");
        }
//        判断手机号是否存在
        SysUserEntity user1 = baseMapper.getByMobile(entity.getMobile());
        if (user1 != null){
            throw new ServerException("手机号已经存在");
        }

//        保存用户
        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysUserVO vo) {
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);
//        判断用户是否存在
        SysUserEntity user = baseMapper.getByUsername(entity.getUsername());
        if (user!=null && !user.getId().equals(entity.getId())){
            throw new ServerException("用户名已存在");
        }
        SysUserEntity user1 = baseMapper.getByMobile(entity.getMobile());
        if (user1!=null && !user1.getId().equals(entity.getId())){
            throw new ServerException("手机号已经存在");
        }

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {
       removeByIds(ids);
    }


}
