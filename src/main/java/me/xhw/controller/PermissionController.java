package me.xhw.controller;

import java.util.List;
import com.base.entity.response.ResponseResult;
import me.xhw.entity.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import me.xhw.service.PermissionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


/**
 * @author xhw----2022年08月19日
 */
@RestController
@RequestMapping("/permission")
@Api(tags="权限管理",description="提供增、删、改、查")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;


	@PostMapping("/getPermissionList")
	@ApiOperation(value = "查询权限列表")
	public  ResponseResult<List<PermissionVo>> getPermissionList(){
		return permissionService.getPermissionList();
	}




//	@PostMapping("/queryForList")
//	@ApiOperation(value = "查询list")
//	public ResponseResult<List<Permission>> queryForList(@RequestBody QueryParams<Permission> queryParams){
//		return permissionService.queryForList(queryParams);
//	}
//
//	@GetMapping("/queryById/{id}")
//	@ApiOperation(value = "根据id查询")
//	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
//	public ResponseResult<Permission> queryById(@PathVariable("id")Long id){
//		return permissionService.queryById(id);
//	}
//
//	@PostMapping("/queryForPage")
//	@ApiOperation(value = "查询分页")
//	public ResponseResult<PageEntity> queryForPage(@RequestBody QueryParams<Permission> queryParams){
//		return permissionService.queryForPage(queryParams);
//	}
//
//	@PostMapping("/modifyFillById")
//	@ApiOperation(value = "根据id修改")
//	public ResponseResult<Permission> modifyFillById(@RequestBody Permission permission){
//		return permissionService.modifyFillById(permission);
//	}
//
//	@GetMapping("/deleteById/{id}")
//	@ApiOperation(value = "根据id删除")
//	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
//	public ResponseResult<Integer> deleteById(@PathVariable("id")Long id){
//		return permissionService.deleteById(id);
//	}
//
//	@GetMapping("/deleteByIds")
//	@ApiOperation(value = "批量删除")
//	@ApiImplicitParam(name = "ids", value = "1,2", required = true, dataType = "Long", paramType = "query")
//	public ResponseResult<Integer> deleteByIds(Long[] ids){
//		return permissionService.deleteByIds(ids);
//	}
//
//	@PostMapping("/insertFill")
//	@ApiOperation(value = "新增")
//	public ResponseResult<Integer> insertFill(@RequestBody Permission permission){
//		return permissionService.insertFill(permission);
//	}
//
//	@PostMapping("/insertFillReturnId")
//	@ApiOperation(value = "新增返回主键")
//	public ResponseResult<Permission> insertFillReturnId(@RequestBody Permission permission){
//		return permissionService.insertFillReturnId(permission);
//	}
//
//	@PostMapping("/batchSave")
//	@ApiOperation(value = "批量新增")
//	public ResponseResult<Integer> batchSave(@RequestBody List<Permission> permissionList){
//		return 	permissionService.batchSave(permissionList);
//	}
	
}
