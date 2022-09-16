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
@Api(tags="角色权限关系管理")
public class RolePermissionRelationController {

	@Autowired
	private RolePermissionRelationService rolePermissionRelationService;

	
}
