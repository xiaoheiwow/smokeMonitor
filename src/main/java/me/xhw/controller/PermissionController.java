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
@Api(tags="权限管理")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;


	@PostMapping("/getPermissionList")
	@ApiOperation(value = "查询权限列表")
	public  ResponseResult<List<PermissionVo>> getPermissionList(){
		return permissionService.getPermissionList();
	}

	
}
