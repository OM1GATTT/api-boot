package top.om1ga.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月03日 19:57
 * @Description:
 * @since: 1.0
 */
@Data
@Schema(description = "手机号登录vo")
public class SysMobileLoginVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "验证码")
    private String code;
}