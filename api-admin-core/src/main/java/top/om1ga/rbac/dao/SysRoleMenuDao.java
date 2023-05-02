package top.om1ga.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.om1ga.mybatis.dao.BaseDao;
import top.om1ga.rbac.entity.SysRoleMenuEntity;

import java.util.List;


/**
 * 角色与菜单对应关系 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {
    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Long> getMenuIdList(@Param("roleId") Long roleId);
}
