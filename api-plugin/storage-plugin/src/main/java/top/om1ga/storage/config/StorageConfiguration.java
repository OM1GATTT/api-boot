package top.om1ga.storage.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.om1ga.storage.enums.StorageTypeEnum;
import top.om1ga.storage.properties.StorageProperties;
import top.om1ga.storage.service.AliyunStorageService;
import top.om1ga.storage.service.LocalStorageService;
import top.om1ga.storage.service.MinioStorageService;
import top.om1ga.storage.service.StorageService;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月04日 16:02
 * @Description: 存储配置文件
 * @since: 1.0
 */
@Configuration
@EnableConfigurationProperties(StorageProperties.class)
@ConditionalOnProperty(prefix = "storage", value = "enabled")
public class StorageConfiguration {

    @Bean
    public StorageService storageService(StorageProperties properties) {
        if (properties.getConfig().getType() == StorageTypeEnum.LOCAL) {
            return new LocalStorageService(properties);
        } else if (properties.getConfig().getType() == StorageTypeEnum.ALIYUN) {
            return new AliyunStorageService(properties);
        } else if (properties.getConfig().getType() == StorageTypeEnum.MINIO) {
            return new MinioStorageService(properties);
        }
        return null;
    }
}
