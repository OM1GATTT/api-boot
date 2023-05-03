package top.om1ga.rbac.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.om1ga.sms.api.SmsApi;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月03日 19:58
 * @Description:
 * @since: 1.0
 */
@Configuration
public class LoginConfig {

    @Bean
    @ConditionalOnMissingBean
    SmsApi smsApi(){
        return new SmsApi() {
            @Override
            public boolean sendCode(String mobile, String key, String value) {
                return false;
            }

            @Override
            public boolean verifyCode(String mobile, String code) {
                return false;
            }
        };
    }
}
