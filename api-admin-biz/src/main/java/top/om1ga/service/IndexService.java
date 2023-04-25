package top.om1ga.service;

import top.om1ga.vo.BarVO;
import top.om1ga.vo.LabelVO;
import top.om1ga.vo.PanelVO;

import java.util.List;
import java.util.Map;

public interface IndexService {
    /**
     * 后台首页统计1：项目主要数据统计面板
     */
     List<PanelVO> statistics1();

    /**
     * 后台首页统计2：echarts 柱状图
     */
    BarVO statistics2(String type);

    /**
     * 后台首页统计3：分类统计标签
     */
    Map<String,List<LabelVO>> statistics3();
}
