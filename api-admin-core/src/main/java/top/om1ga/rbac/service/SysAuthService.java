package top.om1ga.rbac.service;


import top.om1ga.rbac.vo.SysAccountLoginVO;
import top.om1ga.rbac.vo.SysMobileLoginVO;
import top.om1ga.rbac.vo.SysTokenVO;

/**
 * 权限认证服务
 *
 * @author mqxu
 */
public interface SysAuthService {

    /**
     * 账号密码登录
     *
     * @param login 登录信息
     */
    SysTokenVO loginByAccount(SysAccountLoginVO login);

    /**
     * 退出登录
     *
     * @param accessToken accessToken
     */
    void logout(String accessToken);

    /**
     * 手机短信登录
     * @param login 登录信息
     * @return 登录token
     */
    SysTokenVO loginByMobile(SysMobileLoginVO login);

    /**
     * 发送手机验证码
     * @param mobile 手机号
     * @return 是否发送成功
     */
    Boolean sendCode(String mobile);
}
