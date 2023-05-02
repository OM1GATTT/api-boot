package top.om1ga.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.om1ga.common.query.Query;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月02日 11:22
 * @Description:
 * @since: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "角色查询")
public class SysRoleQuery extends Query {
    @Schema(description = "角色名称")
    private String name;

}
