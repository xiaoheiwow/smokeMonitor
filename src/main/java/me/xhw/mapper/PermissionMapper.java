package me.xhw.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Permission;

/**
 * @author xhw----2022年08月19日
 */
@Mapper
public interface PermissionMapper {

	List<Permission> selectList(QueryParams<Permission> queryParams);

	Permission selectById(Long id);

	int selectCount(QueryParams<Permission> queryParams);

	int updateByPrimaryKey(@Param("data")Permission permission);

	int deleteById(Long id);

	int deleteByIds(Long[] ids);

	int insertFill(@Param("data")Permission permission);

	int insertFillReturnId(@Param("data")Permission permission);

	int batchInsert(List<Permission> permissionList);

	List<Permission> selectPermissionList();

    Long[] selectSubId(Long id);
}
