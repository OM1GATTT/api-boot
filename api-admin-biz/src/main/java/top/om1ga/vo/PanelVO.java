package top.om1ga.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月25日 13:41
 * @Description:
 * @since: 1.0
 */
@Data
@Builder
@Schema(description = "数据统计")
public class PanelVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "标题",requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;


    @Schema(description = "数量",requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer value;

    @Schema(description = "单位",requiredMode = Schema.RequiredMode.REQUIRED)
    private String unit;

    @Schema(description = "色彩",requiredMode = Schema.RequiredMode.REQUIRED)
    private String unitColor;

    @Schema(description = "子标题")
    private String subTitle;

    @Schema(description = "子标题值")
    private Integer subValue;

    @Schema(description = "子标题单位")
    private String subUnit;

}
