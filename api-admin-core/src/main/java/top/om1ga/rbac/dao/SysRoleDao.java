package top.om1ga.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.om1ga.mybatis.dao.BaseDao;
import top.om1ga.rbac.entity.SysRoleEntity;

import java.util.List;

/**
 * 角色管理 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {
    public List<Long> getRoleIdList(Long userId);
}
