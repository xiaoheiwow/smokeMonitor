package me.xhw.mapper;

import java.util.List;
import java.util.Date;

import me.xhw.entity.vo.RoleSelectVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Role;

/**
 * @author xhw----2022年08月19日
 */
@Mapper
public interface RoleMapper {

	List<Role> selectList(QueryParams<Role> queryParams);

	int selectCount(QueryParams<Role> queryParams);

	Role selectById(Long id);

	int updateByPrimaryKey(@Param("data")Role role);

	int deleteById(Long id);

	int deleteByIds(Long[] ids);

	int insertFill(@Param("data")Role role);

	int insertFillReturnId(@Param("data")Role role);

	int batchInsert(List<Role> roleList);

    List<RoleSelectVo> fetchName();

	Long queryRoleId(String name);
}
