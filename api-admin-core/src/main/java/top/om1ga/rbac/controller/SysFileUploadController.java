package top.om1ga.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.om1ga.common.utils.Result;
import top.om1ga.rbac.vo.SysFileUploadVO;
import top.om1ga.storage.service.StorageService;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月04日 16:41
 * @Description: 文件上传接口
 * @since: 1.0
 */
@RestController
@RequestMapping("sys/file")
@Tag(name = "文件上传")
@AllArgsConstructor
public class SysFileUploadController {
    private final StorageService storageService;

    @PostMapping("upload")
    @Operation(summary = "上传")
    public Result<SysFileUploadVO> upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return Result.error("请选择需要上传的文件");
        }
        // 上传路径
        String path = storageService.getPath(file.getOriginalFilename());
        // 上传文件
        String url = storageService.upload(file.getBytes(), path);
        SysFileUploadVO vo = new SysFileUploadVO();
        vo.setUrl(url);
        vo.setSize(file.getSize());
        vo.setName(file.getOriginalFilename());
        vo.setPlatform(storageService.properties.getConfig().getType().name());
        return Result.ok(vo);
    }
}
