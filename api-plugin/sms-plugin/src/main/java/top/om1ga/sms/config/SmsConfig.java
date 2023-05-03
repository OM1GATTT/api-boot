package top.om1ga.sms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月02日 22:03
 * @Description: 短信配置项
 * @since: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.sms") // 配置文件的前缀
public class SmsConfig {
    /**
     * 平台  0：阿里云   1：腾讯云
     */
    private Integer platform;

    /**
     * 短信签名
     */
    private String signName;

    /**
     * 短信模板
     */
    private String templateId;

    /**
     * AccessKey
     */
    private String accessKey;

    /**
     * SecretKey
     */
    private String secretKey;

}
