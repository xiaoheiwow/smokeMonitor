package me.xhw.mapper;

import java.util.List;
import java.util.Date;

import me.xhw.entity.vo.DepartmentSelectVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Department;

/**
 * @author xhw----2022年08月19日
 */
@Mapper
public interface DepartmentMapper {

	List<Department> selectList(QueryParams<Department> queryParams);

	Department selectById(Long id);

	int selectCount(QueryParams<Department> queryParams);

	int updateByPrimaryKey(@Param("data")Department department);

	int deleteById(Long id);

	int deleteByIds(Long[] ids);

	int insertFill(@Param("data")Department department);

	int insertFillReturnId(@Param("data")Department department);

	int batchInsert(List<Department> departmentList);

    List<DepartmentSelectVo> fetchName(Long id);
}
