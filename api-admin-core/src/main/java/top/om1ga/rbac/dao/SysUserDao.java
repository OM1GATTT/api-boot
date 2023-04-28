package top.om1ga.rbac.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.om1ga.mybatis.dao.BaseDao;
import top.om1ga.rbac.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统用户 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {

	default SysUserEntity getByUsername(String username){
		return this.selectOne(new QueryWrapper<SysUserEntity>().eq("username", username));
	}

	default SysUserEntity getByMobile(String mobile){
		return this.selectOne(new QueryWrapper<SysUserEntity>().eq("mobile", mobile));
	}

	/**
	 * 根据条件查询用户数据
	 * @param params 参数
	 * @return List<SysUserEntity>
	 */
	List<SysUserEntity> getList(Map<String,Object> params);

	/**
	 * 根据 id 查询用户信息
	 * @param id id
	 * @return SysUserEntity
	 */
	SysUserEntity getById(@Param("id") Long id);
}