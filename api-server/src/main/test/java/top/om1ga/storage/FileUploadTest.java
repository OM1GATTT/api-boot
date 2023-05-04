package top.om1ga.storage;

import cn.hutool.core.io.IoUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.om1ga.storage.service.StorageService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月04日 16:09
 * @Description:
 * @since: 1.0
 */
@SpringBootTest
@Slf4j
public class FileUploadTest {

    @Autowired
    private StorageService storageService;

    @Test
    public void uploadTest() throws IOException {
        File file = new File("C:\\Users\\84508\\Downloads\\image\\bg6.png");
        byte[] data = IoUtil.readBytes(Files.newInputStream(file.toPath()));
        String path = storageService.getPath(file.getName());
        String url = storageService.upload(data, path);
        log.info(url);
    }
}
