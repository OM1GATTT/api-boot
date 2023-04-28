package top.om1ga.rbac.service;


import top.om1ga.mybatis.service.BaseService;
import top.om1ga.rbac.entity.SysRoleEntity;

import java.util.List;

/**
 * 角色
 *
 * @author mqxu
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {
    public List<Long> getRoleIdList(Long id);
}
