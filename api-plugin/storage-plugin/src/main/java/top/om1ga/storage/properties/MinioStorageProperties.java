package top.om1ga.storage.properties;

import lombok.Data;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月04日 15:56
 * @Description: Minio存储配置项
 * @since: 1.0
 */
@Data
public class MinioStorageProperties {
    private String endPoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
