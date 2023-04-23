package top.om1ga.common.excel;

import java.util.List;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月23日 19:19
 * @Description:
 * @since: 1.0
 */
public interface ExcelFinishCallBack<T> {
    /**
     * 导出后置处理数据
     *
     * @param result result
     */
    void doAfterAllAnalysed(List<T> result);

    /**
     * @param result result
     */
    default void doSaveBatch(List<T> result) {
    }
}
