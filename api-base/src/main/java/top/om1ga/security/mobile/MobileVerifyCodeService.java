package top.om1ga.security.mobile;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月03日 19:47
 * @Description:
 * @since: 1.0
 */
public interface MobileVerifyCodeService {

    boolean verifyCode(String mobile, String code);
}
