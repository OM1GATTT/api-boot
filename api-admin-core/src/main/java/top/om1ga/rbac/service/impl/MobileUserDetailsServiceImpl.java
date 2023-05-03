package top.om1ga.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.om1ga.rbac.dao.SysUserDao;
import top.om1ga.rbac.entity.SysUserEntity;
import top.om1ga.rbac.service.SysUserDetailsService;
import top.om1ga.security.mobile.MobileUserDetailsService;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月03日 20:11
 * @Description:
 * @since: 1.0
 */
@Service
@AllArgsConstructor
public class MobileUserDetailsServiceImpl implements MobileUserDetailsService {
    private final SysUserDetailsService sysUserDetailsService;
    private final SysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
        SysUserEntity userEntity = sysUserDao.getByMobile(mobile);
        if(userEntity==null){
            throw new UsernameNotFoundException("手机号或验证码错误");
        }

        return sysUserDetailsService.getUserDetails(userEntity);
    }
}
