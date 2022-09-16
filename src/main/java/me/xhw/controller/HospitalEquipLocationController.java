package me.xhw.controller;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.HospitalEquipLocation;
import me.xhw.entity.vo.EquipLocationVo;
import org.springframework.beans.factory.annotation.Autowired;
import me.xhw.service.HospitalEquipLocationService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


/**
 * @author xhw----2022年08月18日
 */
@RestController
@RequestMapping("/equipLocation")
@Api(tags="设备点位管理")
public class HospitalEquipLocationController {

	@Autowired
	private HospitalEquipLocationService hospitalEquipLocationService;

	@PostMapping("/queryForList")
	@ApiOperation(value = "查询list")
	public ResponseResult<List<EquipLocationVo>> queryForList(@RequestBody QueryParams<EquipLocationVo> queryParams){
		return hospitalEquipLocationService.queryForList(queryParams);
	}

//	@GetMapping("/queryById/{id}")
//	@ApiOperation(value = "根据id查询")
//	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
//	public ResponseResult<HospitalEquipLocation> queryById(@PathVariable("id")Long id){
//		return hospitalEquipLocationService.queryById(id);
//	}
//
//	@PostMapping("/queryForPage")
//	@ApiOperation(value = "查询分页")
//	public ResponseResult<PageEntity> queryForPage(@RequestBody QueryParams<HospitalEquipLocation> queryParams){
//		return hospitalEquipLocationService.queryForPage(queryParams);
//	}
//
	@PostMapping("/modifyFillById")
	@ApiOperation(value = "根据id修改")
	public ResponseResult<HospitalEquipLocation> modifyFillById(@RequestBody HospitalEquipLocation hospitalEquipLocation){
		return hospitalEquipLocationService.modifyFillById(hospitalEquipLocation);
	}

	@GetMapping("/deleteById/{id}")
	@ApiOperation(value = "根据id删除")
	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<Integer> deleteById(@PathVariable("id")Long id){
		return hospitalEquipLocationService.deleteById(id);
	}

	@PostMapping("/deleteByIds")
	@ApiOperation(value = "批量删除")
	public ResponseResult<Integer> deleteByIds(@RequestBody Long[] ids){
		return hospitalEquipLocationService.deleteByIds(ids);
	}

	@PostMapping("/insertFill")
	@ApiOperation(value = "新增")
	public ResponseResult<Integer> insertFill(@RequestBody HospitalEquipLocation hospitalEquipLocation){
		return hospitalEquipLocationService.insertFill(hospitalEquipLocation);
	}
//
//	@PostMapping("/insertFillReturnId")
//	@ApiOperation(value = "新增返回主键")
//	public ResponseResult<HospitalEquipLocation> insertFillReturnId(@RequestBody HospitalEquipLocation hospitalEquipLocation){
//		return hospitalEquipLocationService.insertFillReturnId(hospitalEquipLocation);
//	}
//
//	@PostMapping("/batchSave")
//	@ApiOperation(value = "批量新增")
//	public ResponseResult<Integer> batchSave(@RequestBody List<HospitalEquipLocation> hospitalEquipLocationList){
//		return 	hospitalEquipLocationService.batchSave(hospitalEquipLocationList);
//	}
//
}
