package me.xhw.controller;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Hospital;
import me.xhw.entity.vo.HospitalListVo;
import me.xhw.entity.vo.HospitalSelectVo;
import org.springframework.beans.factory.annotation.Autowired;
import me.xhw.service.HospitalService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @author xhw----2022年08月16日
 */
@RestController
@RequestMapping("/hospital")
@Api(tags="医院管理")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;


	@PostMapping("/queryForList")
	@ApiOperation(value = "查询list")
	public ResponseResult<List<HospitalListVo>> queryForList(@RequestBody QueryParams<HospitalListVo> queryParams){
		return hospitalService.queryForList(queryParams);
	}

	@PostMapping("/queryForPage")
	@ApiOperation(value = "查询分页")
	public ResponseResult<PageEntity> queryForPage(@RequestBody QueryParams<HospitalListVo> queryParams){
		return hospitalService.queryForPage(queryParams);
	}

	@GetMapping("/deleteById/{id}")
	@ApiOperation(value = "根据id删除")
	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<Integer> deleteById(@PathVariable("id")Long id){
		return hospitalService.deleteById(id);
	}

	@PostMapping("/deleteByIds")
	@ApiOperation(value = "批量删除")
	@ApiImplicitParam(name = "ids", value = "1,2", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<Integer> deleteByIds(@RequestBody Long[] ids){
		return hospitalService.deleteByIds(ids);
	}

	@PostMapping("/fetchLevel")
	@ApiOperation(value = "获取级别列表")
	public ResponseResult<List<String>> fetchLevel(){
		return hospitalService.fetchLevel();
	}

	@PostMapping("/fetchRegion")
	@ApiOperation(value = "获取区域列表")
	public ResponseResult<List<String>> fetchRegion(){
		return hospitalService.fetchRegion();
	}

	@PostMapping("/fetchName")
	@ApiOperation(value = "获取名称列表")
	public ResponseResult<List<HospitalSelectVo>> fetchName(){
		return hospitalService.fetchName();
	}

	@PostMapping("/modifyFillById")
	@ApiOperation(value = "根据id修改")
	public ResponseResult<Hospital> modifyFillById(@RequestBody Hospital hospital){
		return hospitalService.modifyFillById(hospital);
	}



	@GetMapping("/queryById/{id}")
	@ApiOperation(value = "根据id查询")
	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<Hospital> queryById(@PathVariable("id")Long id){
		return hospitalService.queryById(id);
	}

	@PostMapping("/addHospital")
	@ApiOperation(value = "新增")
	public ResponseResult<Integer> addHospital(@RequestBody Hospital hospital){
		return hospitalService.insertFill(hospital);
	}



}
