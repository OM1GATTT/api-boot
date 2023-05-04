package top.om1ga.storage.config;
import jakarta.annotation.Resource;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import top.om1ga.storage.enums.StorageTypeEnum;
import top.om1ga.storage.properties.LocalStorageProperties;
import top.om1ga.storage.properties.StorageProperties;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月04日 16:00
 * @Description: 本地资源映射配置
 * @since: 1.0
 */
@Configuration
@ConditionalOnProperty(prefix = "storage", value = "enabled")
public class LocalResourceConfiguration implements WebMvcConfigurer {
    @Resource
    private StorageProperties properties;

    @Override
    public void addResourceHandlers(@NotNull ResourceHandlerRegistry registry) {
        // 如果不是本地存储，则返回
        if (properties.getConfig().getType() != StorageTypeEnum.LOCAL) {
            return;
        }
        LocalStorageProperties local = properties.getLocal();
        registry.addResourceHandler("/" + local.getUrl() + "/**")
                .addResourceLocations("file:" + local.getPath() + "/");
    }
}