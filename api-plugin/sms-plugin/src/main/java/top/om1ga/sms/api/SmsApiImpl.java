package top.om1ga.sms.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import top.om1ga.sms.cache.SmsSendCache;
import top.om1ga.sms.service.SmsService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月02日 22:10
 * @Description:
 * @since: 1.0
 */
@Component
@AllArgsConstructor
public class SmsApiImpl implements SmsApi {
    private final SmsService smsService;
    private final SmsSendCache smsSendCache;

    @Override
    public boolean sendCode(String mobile, String key, String value) {
        // 短信参数
        Map<String, String> params = new HashMap<>();
        params.put(key, value);
        // 发送短信
        boolean flag = smsService.send(mobile, params);
        if (flag) {
            smsSendCache.saveCode(mobile, value);
        }
        return flag;
    }

    @Override
    public boolean verifyCode(String mobile, String code) {
        String value = smsSendCache.getCode(mobile);
        if (value != null) {
            // 删除短信验证码
            smsSendCache.deleteCode(mobile);
            // 校验
            return value.equalsIgnoreCase(code);
        }
        return false;
    }
}
