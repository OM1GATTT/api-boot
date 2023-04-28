package top.om1ga.rbac.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;
import top.om1ga.common.query.Query;
import top.om1ga.common.utils.DateUtils;
import top.om1ga.rbac.vo.SysUserVO;

import java.util.Date;
import java.util.List;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月28日 14:30
 * @Description:
 * @since: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "用户列表查询参数")
public class SysUserQuery extends Query {
    @Schema(description = "id")
    private Long id;

    @Schema(description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "姓名", requiredMode = Schema.RequiredMode.REQUIRED)
    private String realName;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "性别 0：男   1：女   2：未知",requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer gender;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "手机号", requiredMode = Schema.RequiredMode.REQUIRED)
    private String mobile;

    @Schema(description = "状态 0：停用    1：正常", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer status;

    @Schema(description = "角色ID列表")
    private List<Long> roleIdList;

    @Schema(description = "超级管理员   0：否   1：是")
    private Integer superAdmin;


    @Schema(description = "创建时间")
    private Date createTime;
}
