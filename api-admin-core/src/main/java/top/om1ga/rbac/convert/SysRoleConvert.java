package top.om1ga.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.om1ga.rbac.entity.SysRoleEntity;
import top.om1ga.rbac.vo.SysRoleVO;

import java.util.List;

@Mapper
public interface SysRoleConvert {
    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

    SysRoleVO convert(SysRoleEntity entity);

    SysRoleEntity convert(SysRoleVO vo);

    List<SysRoleVO> convertList(List<SysRoleEntity> list);

}
