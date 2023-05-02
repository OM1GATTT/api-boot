package top.om1ga.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月02日 11:23
 * @Description:
 * @since: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "分配角色查询")
public class SysRoleUserQuery extends SysUserQuery {
    @Schema(description = "角色ID")
    private Long roleId;

}
