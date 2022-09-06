package me.xhw.controller;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Department;
import me.xhw.entity.vo.DepartmentSelectVo;
import me.xhw.entity.vo.HospitalSelectVo;
import org.springframework.beans.factory.annotation.Autowired;
import me.xhw.service.DepartmentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


/**
 * @author xhw----2022年08月19日
 */
@RestController
@RequestMapping("/department")
@Api(tags="部门管理",description="提供增、删、改、查")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/queryForList")
	@ApiOperation(value = "查询list")
	public ResponseResult<List<Department>> queryForList(@RequestBody QueryParams<Department> queryParams){
		return departmentService.queryForList(queryParams);
	}

	@GetMapping("/deleteById/{id}")
	@ApiOperation(value = "根据id删除")
	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<Integer> deleteById(@PathVariable("id")Long id){
		return departmentService.deleteById(id);
	}

	@PostMapping("/deleteByIds")
	@ApiOperation(value = "批量删除")
	public ResponseResult<Integer> deleteByIds(@RequestBody Long[] ids){
		return departmentService.deleteByIds(ids);
	}

	@PostMapping("/modifyFillById")
	@ApiOperation(value = "根据id修改")
	public ResponseResult<Department> modifyFillById(@RequestBody Department department){
		return departmentService.modifyFillById(department);
	}

	@PostMapping("/insertFill")
	@ApiOperation(value = "新增")
	public ResponseResult<Integer> insertFill(@RequestBody Department department){
		return departmentService.insertFill(department);
	}

	@GetMapping("/fetchDeptName/{id}")
	@ApiOperation(value = "获取某医院下所有部门名称")
	public ResponseResult<List<DepartmentSelectVo>> fetchName(@PathVariable("id") Long id){
		return departmentService.fetchName(id);
	}

//	@GetMapping("/queryById/{id}")
//	@ApiOperation(value = "根据id查询")
//	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
//	public ResponseResult<Department> queryById(@PathVariable("id")Long id){
//		return departmentService.queryById(id);
//	}
//
//	@PostMapping("/queryForPage")
//	@ApiOperation(value = "查询分页")
//	public ResponseResult<PageEntity> queryForPage(@RequestBody QueryParams<Department> queryParams){
//		return departmentService.queryForPage(queryParams);
//	}
//


//	@PostMapping("/insertFillReturnId")
//	@ApiOperation(value = "新增返回主键")
//	public ResponseResult<Department> insertFillReturnId(@RequestBody Department department){
//		return departmentService.insertFillReturnId(department);
//	}
//
//	@PostMapping("/batchSave")
//	@ApiOperation(value = "批量新增")
//	public ResponseResult<Integer> batchSave(@RequestBody List<Department> departmentList){
//		return 	departmentService.batchSave(departmentList);
//	}
	
}
