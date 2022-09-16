package me.xhw.controller;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Role;
import me.xhw.entity.dto.AddRoleDTO;
import me.xhw.entity.vo.HospitalSelectVo;
import me.xhw.entity.vo.RoleSelectVo;
import org.springframework.beans.factory.annotation.Autowired;
import me.xhw.service.RoleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


/**
 * @author xhw----2022年08月19日
 */
@RestController
@RequestMapping("/role")
@Api(tags="角色管理")
public class RoleController {

	@Autowired
	private RoleService roleService;

//	@PostMapping("/queryForList")
//	@ApiOperation(value = "查询list")
//	public ResponseResult<List<Role>> queryForList(@RequestBody QueryParams<Role> queryParams){
//		return roleService.queryForList(queryParams);
//	}



	@PostMapping("/queryForPage")
	@ApiOperation(value = "查询分页")
	public ResponseResult<PageEntity> queryForPage(@RequestBody QueryParams<Role> queryParams){
		return roleService.queryForPage(queryParams);
	}

	@PostMapping("/modifyFillById")
	@ApiOperation(value = "根据id修改")
	public ResponseResult<Role> modifyFillById(@RequestBody Role role){
		return roleService.modifyFillById(role);
	}

	@GetMapping("/deleteById/{id}")
	@ApiOperation(value = "根据id删除")
	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<Integer> deleteById(@PathVariable("id")Long id){
		return roleService.deleteById(id);
	}

	@PostMapping("/deleteByIds")
	@ApiOperation(value = "批量删除")
	public ResponseResult<Integer> deleteByIds(@RequestBody Long[] ids){
		return roleService.deleteByIds(ids);
	}

	@PostMapping("/insertRoleAndPermission")
	@ApiOperation(value = "新增角色和权限关系")
	public ResponseResult<Integer> insertRoleAndPermission(@RequestBody AddRoleDTO addRoleDTO){
		return roleService.insertRoleAndPermission(addRoleDTO);
	}

	@PostMapping("/fetchRoleName")
	@ApiOperation(value = "获取名称列表")
	public ResponseResult<List<RoleSelectVo>> fetchRoleName(){
		return roleService.fetchRoleName();
	}


//	@PostMapping("/insertFillReturnId")
//	@ApiOperation(value = "新增返回主键")
//	public ResponseResult<Role> insertFillReturnId(@RequestBody Role role){
//		return roleService.insertFillReturnId(role);
//	}
//
//	@PostMapping("/batchSave")
//	@ApiOperation(value = "批量新增")
//	public ResponseResult<Integer> batchSave(@RequestBody List<Role> roleList){
//		return 	roleService.batchSave(roleList);
//	}

}
