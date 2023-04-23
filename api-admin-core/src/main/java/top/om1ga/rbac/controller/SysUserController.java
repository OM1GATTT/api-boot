package top.om1ga.rbac.controller;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月23日 20:56
 * @Description:
 * @since: 1.0
 */
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.om1ga.common.utils.Result;
import top.om1ga.rbac.convert.SysUserConvert;
import top.om1ga.rbac.service.SysMenuService;
import top.om1ga.rbac.vo.SysAuthVO;
import top.om1ga.rbac.vo.SysUserVO;
import top.om1ga.security.user.SecurityUser;
import top.om1ga.security.user.UserDetail;

/**
 * 系统用户接口
 *
 * @author mqxu
 **/
@RestController
@RequestMapping("sys/user")
@AllArgsConstructor
@Tag(name = "用户管理")
public class SysUserController {
    private final SysMenuService sysMenuService;

    @PostMapping("info")
    @Operation(summary = "获取登录用户信息")
    public Result<SysAuthVO> info() {
        SysAuthVO vo = new SysAuthVO();
        UserDetail userDetail = SecurityUser.getUser();
        //1 获得用户详细信息，转成 vo
        SysUserVO user = SysUserConvert.INSTANCE.convert(userDetail);
        vo.setSysUserVO(user);
        //2 获取用户导航菜单
        vo.setNav(sysMenuService.getUserMenuList(userDetail, 0));
        //3 获得用户授权信息
        vo.setAuthority(sysMenuService.getUserAuthority(userDetail));
        return Result.ok(vo);
    }
}
