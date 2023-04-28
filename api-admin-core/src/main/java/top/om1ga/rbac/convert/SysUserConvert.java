package top.om1ga.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.om1ga.rbac.entity.SysUserEntity;
import top.om1ga.rbac.vo.SysUserExcelVO;
import top.om1ga.rbac.vo.SysUserVO;
import top.om1ga.security.user.UserDetail;

import java.util.List;


/**
 * 系统用户实体转换
 *
 * @author moqi
 */
@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUserVO convert(SysUserEntity entity);

    UserDetail convertDetail(SysUserEntity entity);

    SysUserEntity convert(SysUserVO vo);

    SysUserVO convert(UserDetail userDetail);

    List<SysUserVO> convertList(List<SysUserEntity> list);

    List<SysUserExcelVO> convert2List(List<SysUserEntity> list);

    List<SysUserEntity> convertListEntity(List<SysUserExcelVO> list);





}
