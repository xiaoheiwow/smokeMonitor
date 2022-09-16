package me.xhw.controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.User;
import me.xhw.entity.dto.UserLoginDTO;
import me.xhw.entity.vo.DepartmentSelectVo;
import me.xhw.entity.vo.UserSelectVo;
import me.xhw.entity.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import me.xhw.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


/**
 * @author xhw----2022年08月16日
 */
@RestController
@RequestMapping("/user")
@Api(tags="用户管理")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private int serverPort;
	@GetMapping("/getToken")
	@ApiOperation(value = "获取token，测试环境使用")
	public String getToken(String account, String pass){
		String str = null;
		JSONObject forObject = restTemplate.getForObject("http://localhost:"+serverPort+"/oauth/token?grant_type=password&client_id=web-client&client_secret=secret&username="+account+"&password="+pass, JSONObject.class);
		if(null != forObject){
			str = forObject.getString("access_token");
		}
		return str;
	}


	@PostMapping("/login")
	@ApiOperation(value = "用户密码登录,密码密文传输---BCrypt加密")
	public ResponseResult<UserVo> loginByPass(@RequestBody UserLoginDTO userLoginDTO){
		return userService.loginByPass(userLoginDTO);
	}

//	@PostMapping("/queryForList")
//	@ApiOperation(value = "查询list")
//	public ResponseResult<List<UserVo>> queryForList(@RequestBody QueryParams<UserVo> queryParams){
//		return userService.queryForList(queryParams);
//	}
//
//	@GetMapping("/queryById/{id}")
//	@ApiOperation(value = "根据id查询")
//	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
//	public ResponseResult<User> queryById(@PathVariable("id")Long id){
//		return userService.queryById(id);
//	}

	@PostMapping("/queryForPage")
	@ApiOperation(value = "查询分页")
	public ResponseResult<PageEntity> queryForPage(@RequestBody QueryParams<UserVo> queryParams){
		return userService.queryForPage(queryParams);
	}


	@GetMapping("/updateStatusById/{id}")
	@ApiOperation(value = "根据id改变启用状态")
	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<Integer> updateStatusById(@PathVariable("id")Long id){
		return userService.updateStatusById(id);
	}


	@PostMapping("/modifyFillById")
	@ApiOperation(value = "根据id修改")
	public ResponseResult<User> modifyFillById(@RequestBody UserVo userVo){
		return userService.modifyFillById(userVo);
	}

	@GetMapping("/deleteById/{id}")
	@ApiOperation(value = "根据id删除")
	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<Integer> deleteById(@PathVariable("id")Long id){
		return userService.deleteById(id);
	}

	@PostMapping("/deleteByIds")
	@ApiOperation(value = "批量删除")
	public ResponseResult<Integer> deleteByIds(@RequestBody Long[] ids){
		return userService.deleteByIds(ids);
	}

	@PostMapping("/insertFill")
	@ApiOperation(value = "新增")
	public ResponseResult<Integer> insertFill(@RequestBody UserVo userVo){
		return userService.insertFill(userVo);
	}


	@GetMapping("/fetchUser/{id}")
	@ApiOperation(value = "获取某医院下所有用户")
	public ResponseResult<List<UserSelectVo>> fetchName(@PathVariable("id") Long id){
		return userService.fetchUser(id);
	}



//	@PostMapping("/batchSave")
//	@ApiOperation(value = "批量新增")
//	public ResponseResult<Integer> batchSave(@RequestBody List<User> userList){
//		return 	userService.batchSave(userList);
//	}
	
}
