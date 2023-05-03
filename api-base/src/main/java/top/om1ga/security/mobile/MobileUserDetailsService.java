package top.om1ga.security.mobile;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface MobileUserDetailsService {
    /**
     * 通过手机号加载用户信息
     *
     * @param mobile 手机号
     * @return 用户信息
     * @throws UsernameNotFoundException 不存在异常
     */
    UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException;

}
