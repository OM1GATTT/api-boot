package top.om1ga.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.om1ga.security.mobile.MobileVerifyCodeService;
import top.om1ga.sms.api.SmsApi;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月03日 20:14
 * @Description:
 * @since: 1.0
 */
@Service
@AllArgsConstructor
public class MobileVerifyCodeServiceImpl implements MobileVerifyCodeService {
    private final SmsApi smsApi;

    @Override
    public boolean verifyCode(String mobile, String code) {
        return smsApi.verifyCode(mobile, code);
    }
}
