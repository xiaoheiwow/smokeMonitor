package me.xhw.controller;

import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Inspector;
import me.xhw.entity.vo.InspectorVo;
import org.springframework.beans.factory.annotation.Autowired;
import me.xhw.service.InspectorService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


/**
 * @author xhw----2022年08月22日
 */
@RestController
@RequestMapping("/inspector")
@Api(tags="巡查人员管理")
public class InspectorController {

	@Autowired
	private InspectorService inspectorService;


	@PostMapping("/queryForPage")
	@ApiOperation(value = "查询分页")
	public ResponseResult<PageEntity> queryForPage(@RequestBody QueryParams<InspectorVo> queryParams){
		return inspectorService.queryForPage(queryParams);
	}

	@PostMapping("/modifyFillById")
	@ApiOperation(value = "根据id修改")
	public ResponseResult<Inspector> modifyFillById(@RequestBody InspectorVo inspectorVo){
		return inspectorService.modifyFillById(inspectorVo);
	}

	@GetMapping("/deleteById/{id}")
	@ApiOperation(value = "根据id删除")
	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<Integer> deleteById(@PathVariable("id")Long id){
		return inspectorService.deleteById(id);
	}

	@PostMapping("/deleteByIds")
	@ApiOperation(value = "批量删除")
	public ResponseResult<Integer> deleteByIds(@RequestBody  Long[] ids){
		return inspectorService.deleteByIds(ids);
	}

	@PostMapping("/insertFill")
	@ApiOperation(value = "新增")
	public ResponseResult<Long> insertFill(@RequestBody InspectorVo inspectorVo){
		return inspectorService.insertFill(inspectorVo);
	}


	@GetMapping("/banInspectorById/{id}")
	@ApiOperation(value = "根据id加入黑名单(禁用)")
	public ResponseResult<Integer> banInspectorById(@PathVariable("id") Long id){
		return inspectorService.banInspectorById(id);
	}

	
}
