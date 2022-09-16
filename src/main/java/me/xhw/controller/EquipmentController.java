package me.xhw.controller;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Equipment;
import me.xhw.entity.vo.EquipmentVo;
import me.xhw.entity.vo.SimpleEquipVo;
import org.springframework.beans.factory.annotation.Autowired;
import me.xhw.service.EquipmentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


/**
 * @author xhw----2022年08月16日
 */
@RestController
@RequestMapping("/equipment")
@Api(tags="设备管理")
public class EquipmentController {

	@Autowired
	private EquipmentService equipmentService;



	@GetMapping("/queryListByHospitalId/{id}")
	@ApiOperation(value = "根据医院id查询设备列表")
	@ApiImplicitParam(name = "id", value = "医院id", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<List<SimpleEquipVo>> queryListByHospitalId(@PathVariable("id")Long id){
		return equipmentService.queryListByHospitalId(id);
	}

	@PostMapping("/batchUpdate")
	@ApiOperation(value = "批量修改")
	public ResponseResult<Integer> batchUpdate(@RequestBody List<Equipment> equipmentList){
		return equipmentService.batchUpdate(equipmentList);
	}

	@PostMapping("/queryForPage")
	@ApiOperation(value = "查询分页")
	public ResponseResult<PageEntity> queryForPage(@RequestBody QueryParams<EquipmentVo> queryParams){
		return equipmentService.queryForPage(queryParams);
	}

	@GetMapping("/updateStatusById/{id}")
	@ApiOperation(value = "根据id修改状态")
	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<Integer> updateStatusById(@PathVariable("id")Long id){
		return equipmentService.updateStatusById(id);
	}

	@PostMapping("/queryForList")
	@ApiOperation(value = "查询list")
	public ResponseResult<List<EquipmentVo>> queryForList(@RequestBody QueryParams<EquipmentVo> queryParams){
		return equipmentService.queryForList(queryParams);
	}

	@GetMapping("/deleteById/{id}")
	@ApiOperation(value = "根据id删除")
	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<Integer> deleteById(@PathVariable("id")Long id){
		return equipmentService.deleteById(id);
	}

	@PostMapping("/deleteByIds")
	@ApiOperation(value = "批量删除")
	public ResponseResult<Integer> deleteByIds(@RequestBody Long[] ids){
		return equipmentService.deleteByIds(ids);
	}


//	@GetMapping("/queryById/{id}")
//	@ApiOperation(value = "根据id查询")
//	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
//	public ResponseResult<Equipment> queryById(@PathVariable("id")Long id){
//		return equipmentService.queryById(id);
//	}



	@PostMapping("/modifyFillById")
	@ApiOperation(value = "根据id修改")
	public ResponseResult<Equipment> modifyFillById(@RequestBody Equipment equipment){
		return equipmentService.modifyFillById(equipment);
	}





	@PostMapping("/insertFill")
	@ApiOperation(value = "新增")
	public ResponseResult<Integer> insertFill(@RequestBody Equipment equipment){
		return equipmentService.insertFill(equipment);
	}


//	@PostMapping("/insertFillReturnId")
//	@ApiOperation(value = "新增返回主键")
//	public ResponseResult<Equipment> insertFillReturnId(@RequestBody Equipment equipment){
//		return equipmentService.insertFillReturnId(equipment);
//	}
//
//	@PostMapping("/batchSave")
//	@ApiOperation(value = "批量新增")
//	public ResponseResult<Integer> batchSave(@RequestBody List<Equipment> equipmentList){
//		return 	equipmentService.batchSave(equipmentList);
//	}
//
}
