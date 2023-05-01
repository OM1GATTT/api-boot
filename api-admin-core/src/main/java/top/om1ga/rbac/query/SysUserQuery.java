package top.om1ga.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.om1ga.common.query.Query;

import java.util.Date;

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

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "姓名")
    private String realName;

    @Schema(description = "性别 0：男   1：女   2：未知")
    private Integer gender;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "创建起始时间")
    private Date beginTime;

    @Schema(description = "创建结束时间")
    private Date endTime;
}
