package me.xhw.controller;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.HospitalBuilding;
import me.xhw.entity.vo.BuildingVo;
import org.springframework.beans.factory.annotation.Autowired;
import me.xhw.service.HospitalBuildingService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


/**
 * @author xhw----2022年08月17日
 */
@RestController
@RequestMapping("/building")
@Api(tags="楼宇管理")
public class HospitalBuildingController {

	@Autowired
	private HospitalBuildingService hospitalBuildingService;

	@PostMapping("/queryForList")
	@ApiOperation(value = "查询list")
	public ResponseResult<List<BuildingVo>> queryForList(@RequestBody QueryParams<BuildingVo> queryParams){
		return hospitalBuildingService.queryForList(queryParams);
	}

	@PostMapping("/queryForPage")
	@ApiOperation(value = "查询分页")
	public ResponseResult<PageEntity> queryForPage(@RequestBody QueryParams<BuildingVo> queryParams){
		return hospitalBuildingService.queryForPage(queryParams);
	}

	@PostMapping("/updateBuilding")
	@ApiOperation(value = "根据id修改")
	public ResponseResult<HospitalBuilding> modifyFillById(@RequestBody HospitalBuilding hospitalBuilding){
		return hospitalBuildingService.modifyFillById(hospitalBuilding);
	}

	@GetMapping("/deleteById/{id}")
	@ApiOperation(value = "根据id删除")
	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<Integer> deleteById(@PathVariable("id")Long id){
		return hospitalBuildingService.deleteById(id);
	}

	@PostMapping("/deleteByIds")
	@ApiOperation(value = "批量删除")
	public ResponseResult<Integer> deleteByIds(@RequestBody Long[] ids){
		return hospitalBuildingService.deleteByIds(ids);
	}

	@PostMapping("/insertFill")
	@ApiOperation(value = "新增")
	public ResponseResult<Integer> insertFill(@RequestBody HospitalBuilding hospitalBuilding){
		return hospitalBuildingService.insertFill(hospitalBuilding);
	}

	
}
