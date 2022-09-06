package me.xhw.mapper;

import java.util.List;
import java.util.Date;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.base.entity.query.QueryParams;
import me.xhw.entity.RolePermissionRelation;

/**
 * @author xhw----2022年08月29日
 */
@Mapper
public interface RolePermissionRelationMapper {

	List<RolePermissionRelation> selectList(QueryParams<RolePermissionRelation> queryParams);

	RolePermissionRelation selectById(Long id);

	int selectCount(QueryParams<RolePermissionRelation> queryParams);

	int updateByPrimaryKey(@Param("data")RolePermissionRelation rolePermissionRelation);

	int deleteById(Long id);

	int deleteByIds(Long[] ids);

	int insertFill(@Param("data")RolePermissionRelation rolePermissionRelation);

	int insertFillReturnId(@Param("data")RolePermissionRelation rolePermissionRelation);

	int batchInsert(List<RolePermissionRelation> rolePermissionRelationList);
	
}
