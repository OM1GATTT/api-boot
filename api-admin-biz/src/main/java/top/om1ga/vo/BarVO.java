package top.om1ga.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月25日 13:45
 * @Description:
 * @since: 1.0
 */
@Data
@Builder
@Schema(description = "柱状图")
public class BarVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "x轴数据",requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> x;

    @Schema(description = "y轴数据",requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Integer> y;

}
