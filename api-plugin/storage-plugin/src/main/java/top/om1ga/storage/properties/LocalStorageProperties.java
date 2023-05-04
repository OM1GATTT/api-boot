package top.om1ga.storage.properties;

import lombok.Data;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月04日 15:55
 * @Description: 本地存储配置项
 * @since: 1.0
 */
@Data
public class LocalStorageProperties {
    /**
     * 本地存储路径
     */
    private String path;
    /**
     * 资源起始路径
     */
    private String url = "upload";
}