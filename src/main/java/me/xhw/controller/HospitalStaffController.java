package me.xhw.controller;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.HospitalStaff;
import me.xhw.entity.dto.HospitalStaffUpdateDTO;
import me.xhw.entity.dto.StaffSimpleQueryDTO;
import me.xhw.entity.vo.HospitalStaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import me.xhw.service.HospitalStaffService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


/**
 * @author xhw----2022年08月23日
 */
@RestController
@RequestMapping("/hospitalStaff")
@Api(tags="医务人员管理",description="提供增、删、改、查")
public class HospitalStaffController {

	@Autowired
	private HospitalStaffService hospitalStaffService;

//	@PostMapping("/queryForList")
//	@ApiOperation(value = "查询list")
//	public ResponseResult<List<HospitalStaffVo>> queryForList(@RequestBody QueryParams<HospitalStaffVo> queryParams){
//		return hospitalStaffService.queryForList(queryParams);
//	}

//	@GetMapping("/queryById/{id}")
//	@ApiOperation(value = "根据id查询")
//	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
//	public ResponseResult<HospitalStaff> queryById(@PathVariable("id")Long id){
//		return hospitalStaffService.queryById(id);
//	}

	@PostMapping("/queryForPage")
	@ApiOperation(value = "查询分页")
	public ResponseResult<PageEntity> queryForPage(@RequestBody QueryParams<HospitalStaffVo> queryParams){
		return hospitalStaffService.queryForPage(queryParams);
	}



	@PostMapping("/updateStaff")
	@ApiOperation(value = "根据id修改")
	public ResponseResult<Integer> updateStaff(@RequestBody HospitalStaffUpdateDTO hospitalStaffUpdateDTO){
		return hospitalStaffService.modifyFillById(hospitalStaffUpdateDTO);
	}

	@GetMapping("/deleteById/{id}")
	@ApiOperation(value = "根据id删除")
	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<Integer> deleteById(@PathVariable("id")Long id){
		return hospitalStaffService.deleteById(id);
	}

	@PostMapping("/deleteByIds")
	@ApiOperation(value = "批量删除")
	public ResponseResult<Integer> deleteByIds(@RequestBody Long[] ids){
		return hospitalStaffService.deleteByIds(ids);
	}

	@PostMapping("/insertFill")
	@ApiOperation(value = "新增")
	public ResponseResult<Long> insertFill(@RequestBody HospitalStaffUpdateDTO hospitalStaffUpdateDTO){
		return hospitalStaffService.insertFill(hospitalStaffUpdateDTO);
	}

//	@PostMapping("/insertFillReturnId")
//	@ApiOperation(value = "新增返回主键")
//	public ResponseResult<HospitalStaff> insertFillReturnId(@RequestBody HospitalStaff hospitalStaff){
//		return hospitalStaffService.insertFillReturnId(hospitalStaff);
//	}
//
//	@PostMapping("/batchSave")
//	@ApiOperation(value = "批量新增")
//	public ResponseResult<Integer> batchSave(@RequestBody List<HospitalStaff> hospitalStaffList){
//		return 	hospitalStaffService.batchSave(hospitalStaffList);
//	}
//
}
