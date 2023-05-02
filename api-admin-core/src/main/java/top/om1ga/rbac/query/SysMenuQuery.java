package top.om1ga.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.om1ga.common.query.Query;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月02日 11:23
 * @Description:
 * @since: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "菜单查询")
public class SysMenuQuery extends Query {
    @Schema(description = "菜单类型")
    private Integer type;
}
