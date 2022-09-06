package me.xhw.service;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Department;
import me.xhw.entity.vo.DepartmentSelectVo;
import me.xhw.entity.vo.HospitalSelectVo;

/**
 * @author xhw----2022年08月19日
 */
public interface DepartmentService {

	ResponseResult<List<Department>> queryForList(QueryParams<Department> queryParams);

	ResponseResult<Department> queryById(Long id);

	ResponseResult<PageEntity> queryForPage(QueryParams<Department> queryParams);

	ResponseResult<Department> modifyFillById(Department department);

	ResponseResult<Integer> deleteById(Long id);

	ResponseResult<Integer> deleteByIds(Long[] ids);

	ResponseResult<Integer> insertFill(Department department);

	ResponseResult<Department> insertFillReturnId(Department department);

	ResponseResult<Integer> batchSave(List<Department> departmentList);

    ResponseResult<List<DepartmentSelectVo>> fetchName(Long id);
}
