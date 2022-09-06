package me.xhw.controller;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.RolePermissionRelation;
import org.springframework.beans.factory.annotation.Autowired;
import me.xhw.service.RolePermissionRelationService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


/**
 * @author xhw----2022年08月29日
 */
@RestController
@RequestMapping("/rolePermissionRelation")
@Api(tags="角色权限关系管理",description="提供增、删、改、查")
public class RolePermissionRelationController {

	@Autowired
	private RolePermissionRelationService rolePermissionRelationService;

//	@PostMapping("/queryForList")
//	@ApiOperation(value = "查询list")
//	public ResponseResult<List<RolePermissionRelation>> queryForList(@RequestBody QueryParams<RolePermissionRelation> queryParams){
//		return rolePermissionRelationService.queryForList(queryParams);
//	}
//
//	@GetMapping("/queryById/{id}")
//	@ApiOperation(value = "根据id查询")
//	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
//	public ResponseResult<RolePermissionRelation> queryById(@PathVariable("id")Long id){
//		return rolePermissionRelationService.queryById(id);
//	}
//
//	@PostMapping("/queryForPage")
//	@ApiOperation(value = "查询分页")
//	public ResponseResult<PageEntity> queryForPage(@RequestBody QueryParams<RolePermissionRelation> queryParams){
//		return rolePermissionRelationService.queryForPage(queryParams);
//	}
//
//	@PostMapping("/modifyFillById")
//	@ApiOperation(value = "根据id修改")
//	public ResponseResult<RolePermissionRelation> modifyFillById(@RequestBody RolePermissionRelation rolePermissionRelation){
//		return rolePermissionRelationService.modifyFillById(rolePermissionRelation);
//	}
//
//	@GetMapping("/deleteById/{id}")
//	@ApiOperation(value = "根据id删除")
//	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
//	public ResponseResult<Integer> deleteById(@PathVariable("id")Long id){
//		return rolePermissionRelationService.deleteById(id);
//	}
//
//	@GetMapping("/deleteByIds")
//	@ApiOperation(value = "批量删除")
//	@ApiImplicitParam(name = "ids", value = "1,2", required = true, dataType = "Long", paramType = "query")
//	public ResponseResult<Integer> deleteByIds(Long[] ids){
//		return rolePermissionRelationService.deleteByIds(ids);
//	}
//
//	@PostMapping("/insertFill")
//	@ApiOperation(value = "新增")
//	public ResponseResult<Integer> insertFill(@RequestBody RolePermissionRelation rolePermissionRelation){
//		return rolePermissionRelationService.insertFill(rolePermissionRelation);
//	}
//
//	@PostMapping("/insertFillReturnId")
//	@ApiOperation(value = "新增返回主键")
//	public ResponseResult<RolePermissionRelation> insertFillReturnId(@RequestBody RolePermissionRelation rolePermissionRelation){
//		return rolePermissionRelationService.insertFillReturnId(rolePermissionRelation);
//	}
//
//	@PostMapping("/batchSave")
//	@ApiOperation(value = "批量新增")
//	public ResponseResult<Integer> batchSave(@RequestBody List<RolePermissionRelation> rolePermissionRelationList){
//		return 	rolePermissionRelationService.batchSave(rolePermissionRelationList);
//	}
	
}
