package top.om1ga.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月25日 13:46
 * @Description:
 * @since: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "分类统计标签")
public class LabelVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "标签名",requiredMode = Schema.RequiredMode.REQUIRED)
    private String label;

    @Schema(description = "标签值",requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer value;
}
