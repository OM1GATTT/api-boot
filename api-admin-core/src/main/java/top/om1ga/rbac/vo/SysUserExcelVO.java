package top.om1ga.rbac.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import top.om1ga.common.excel.DateConverter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月28日 14:04
 * @Description:
 * @since: 1.0
 */
@Data
public class SysUserExcelVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelIgnore
    private Long id;

    @ExcelProperty("用户名")
    private String username;

    @ExcelProperty("用户名")
    private String realName;

    @ExcelProperty("性别")
    private Integer gender;

    @ExcelProperty("用户名")
    private String email;

    @ExcelProperty("手机号")
    private String mobile;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty(value = "创建时间",converter = DateConverter.class)
    private Date createTime;
}
