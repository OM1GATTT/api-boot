package top.om1ga.storage.properties;

import lombok.Data;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月04日 15:55
 * @Description: 阿里云存储配置项
 * @since: 1.0
 */
@Data
public class AliyunStorageProperties {
    private String endPoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
