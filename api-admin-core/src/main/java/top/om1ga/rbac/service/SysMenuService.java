package top.om1ga.rbac.service;


import top.om1ga.mybatis.service.BaseService;
import top.om1ga.rbac.entity.SysMenuEntity;
import top.om1ga.rbac.vo.SysMenuVO;
import top.om1ga.security.user.UserDetail;
import top.om1ga.common.utils.PageResult;
import top.om1ga.rbac.query.SysMenuQuery;

import java.util.List;
import java.util.Set;

/**
 * 菜单管理
 *
 * @author mqxu
 */
public interface SysMenuService extends BaseService<SysMenuEntity> {

    /**
     * 菜单列表
     * @param type 菜单类型
     * @return
     */
    List<SysMenuVO> getMenuList(Integer type);

    /**
     * 用户菜单列表
     * @param user 用户
     * @param type 菜单类型
     * @return
     */
    List<SysMenuVO> getUserMenuList(UserDetail user,Integer type);

    /**
     * 获取用户权限列表
     * @param user 用户
     * @return 去重后的权限列表
     */
    Set<String> getUserAuthority(UserDetail user);

    /**
     * 菜单分页
     *
     * @param query 查询参数
     */
    PageResult<SysMenuVO> page(SysMenuQuery query);

    /**
     * 获取子菜单的数量
     * @param pid  父菜单ID
     */
    Long getSubMenuCount(Long pid);

    void save(SysMenuVO vo);

    void update(SysMenuVO vo);

    void delete(Long id);
}
