package top.om1ga.rbac.service;


import org.springframework.web.multipart.MultipartFile;
import top.om1ga.common.utils.PageResult;
import top.om1ga.mybatis.service.BaseService;
import top.om1ga.rbac.entity.SysUserEntity;
import top.om1ga.rbac.query.SysUserQuery;
import top.om1ga.rbac.vo.SysUserVO;

import java.util.List;

/**
 * 用户管理
 *
 * @author mqxu
 */
public interface SysUserService extends BaseService<SysUserEntity> {

    /**
     * 修改密码
     *
     * @param id          用户ID
     * @param newPassword 新密码
     */
    void updatePassword(Long id, String newPassword);

    /**
     * 分页查询用户
     * @param query 查询参数
     * @return 分页数据
     */
    PageResult<SysUserVO> page(SysUserQuery query);

//    SysUserEntity getById(Long id);
    /**
     * 新增用户
     * @param vo 入参
     */
    void save(SysUserVO vo);

    /**
     * 修改用户
     * @param vo 入参
     */
    void update(SysUserVO vo);

    /**
     * 批量删除用户
     * @param ids 入参
     */
    void delete(List<Long> ids);


    void importByExcel(MultipartFile file, String password);

    /**
     * 导出用户信息为excel
     */
    void export();

    /**
     * 修改用户状态
     * @param id 用户id
     * @param status 需要修改的状态
     */
    void updateStatus(long id,int status);
}
