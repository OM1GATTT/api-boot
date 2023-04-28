package top.om1ga.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.om1ga.mybatis.dao.BaseDao;
import top.om1ga.rbac.entity.SysUserRoleEntity;

import java.util.List;

/**
 * 用户角色关系 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {
}