package top.om1ga.sms.context;

import top.om1ga.common.exception.ServerException;
import top.om1ga.sms.config.SmsConfig;
import top.om1ga.sms.enums.SmsPlatformEnum;
import top.om1ga.sms.strategy.AliyunSmsStrategy;
import top.om1ga.sms.strategy.SmsStrategy;

import java.util.Map;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月02日 22:06
 * @Description: 短信 Context
 * @since: 1.0
 */
public class SmsContext {
    private final SmsStrategy smsStrategy;

    public SmsContext(SmsConfig config) {
        if (config.getPlatform() == SmsPlatformEnum.ALIYUN.getValue()) {
            this.smsStrategy = new AliyunSmsStrategy(config);
        } else if (config.getPlatform() == SmsPlatformEnum.TENCENT.getValue()) {
            // TODO 腾讯云短信发送
            this.smsStrategy = null;
        } else {
            throw new ServerException("未知的短信平台");
        }
    }

    public void send(String mobile, Map<String, String> params) {
        smsStrategy.send(mobile, params);
    }
}
