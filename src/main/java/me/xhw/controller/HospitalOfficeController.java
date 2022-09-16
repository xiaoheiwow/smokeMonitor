package me.xhw.controller;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.HospitalOffice;
import me.xhw.entity.vo.DepartmentSelectVo;
import me.xhw.entity.vo.OfficeSelectVo;
import org.springframework.beans.factory.annotation.Autowired;
import me.xhw.service.HospitalOfficeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


/**
 * @author xhw----2022年08月19日
 */
@RestController
@RequestMapping("/office")
@Api(tags="科室管理")
public class HospitalOfficeController {

	@Autowired
	private HospitalOfficeService hospitalOfficeService;

	@PostMapping("/queryForList")
	@ApiOperation(value = "查询list")
	public ResponseResult<List<HospitalOffice>> queryForList(@RequestBody QueryParams<HospitalOffice> queryParams){
		return hospitalOfficeService.queryForList(queryParams);
	}



	@PostMapping("/modifyFillById")
	@ApiOperation(value = "根据id修改")
	public ResponseResult<HospitalOffice> modifyFillById(@RequestBody HospitalOffice hospitalOffice){
		return hospitalOfficeService.modifyFillById(hospitalOffice);
	}

	@GetMapping("/deleteById/{id}")
	@ApiOperation(value = "根据id删除")
	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<Integer> deleteById(@PathVariable("id")Long id){
		return hospitalOfficeService.deleteById(id);
	}

	@PostMapping("/deleteByIds")
	@ApiOperation(value = "批量删除")
	public ResponseResult<Integer> deleteByIds(@RequestBody Long[] ids){
		return hospitalOfficeService.deleteByIds(ids);
	}

	@PostMapping("/insertFill")
	@ApiOperation(value = "新增")
	public ResponseResult<Integer> insertFill(@RequestBody HospitalOffice hospitalOffice){
		return hospitalOfficeService.insertFill(hospitalOffice);
	}

	@GetMapping("/fetchOfficeName/{id}")
	@ApiOperation(value = "获取某医院下所有科室")
	public ResponseResult<List<OfficeSelectVo>> fetchName(@PathVariable("id") Long id){
		return hospitalOfficeService.fetchName(id);
	}

}
