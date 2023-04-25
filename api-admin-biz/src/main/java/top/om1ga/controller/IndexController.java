package top.om1ga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.om1ga.common.utils.Result;
import top.om1ga.service.IndexService;
import top.om1ga.vo.BarVO;
import top.om1ga.vo.LabelVO;
import top.om1ga.vo.PanelVO;

import java.util.List;
import java.util.Map;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月25日 14:07
 * @Description:
 * @since: 1.0
 */
@RestController
@RequestMapping("/sys/index")
@Tag(name = "首页统计")
@AllArgsConstructor
public class IndexController {

    private final IndexService indexService;

    @GetMapping("statistics1")
    @Operation(summary = "项目主要数据统计面板")
    public Result<List<PanelVO>> getStatistics1(){
        List<PanelVO> list = indexService.statistics1();
        return Result.ok(list);
    }

    @GetMapping("statistics2")
    @Operation(summary = "echarts 柱状图")
    public Result<BarVO> getStatistics2(){
        BarVO barVO = indexService.statistics2();
        return Result.ok(barVO);
    }

    @GetMapping("statistics3")
    @Operation(summary = "分类统计标签")
    public Result<Map<String, List<LabelVO>>> getStatistics3(){
        Map<String, List<LabelVO>> map = indexService.statistics3();
        return Result.ok(map);
    }
}
