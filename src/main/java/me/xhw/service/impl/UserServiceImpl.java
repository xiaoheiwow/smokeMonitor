package me.xhw.service.impl;

import com.alibaba.fastjson.JSONObject;
import me.xhw.entity.dto.UserLoginDTO;
import me.xhw.entity.result.BaseTextCode;
import me.xhw.entity.vo.DepartmentSelectVo;
import me.xhw.entity.vo.UserSelectVo;
import me.xhw.entity.vo.UserVo;
import me.xhw.mapper.RoleMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.List;
import java.util.Date;
import me.xhw.entity.User;
import me.xhw.mapper.UserMapper;
import me.xhw.service.UserService;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import com.base.entity.response.TextCode;
import com.base.util.Oauth2Util;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 *@author xhw----2022年08月16日
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	
	protected Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource
	private UserMapper userMapper;

	@Resource
	private RoleMapper roleMapper;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private int serverPort;

	/**
     *查询List
     */
	@Override
	public ResponseResult<List<UserVo>> queryForList(QueryParams<UserVo> queryParams){
		ResponseResult<List<UserVo>> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		List<UserVo> data = null;
		try {
			data = userMapper.selectList(queryParams);
			result.setOk(true);
			result.setData(data);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}

	/**
	 *根据Id查询
 	 */
	@Override
	public ResponseResult<User> queryById(Long id){
		ResponseResult<User> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		User data = null;
		try {
			data = userMapper.selectById(id);
			result.setOk(true);
			result.setData(data);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}


	/**
	 *查询分页
	 */
	@Override
	public ResponseResult<PageEntity> queryForPage(QueryParams<UserVo> queryParams){
		ResponseResult<PageEntity> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		PageEntity page = null;
		try {
			int totalCount = userMapper.selectCount(queryParams);
			if(totalCount > 0){
				page = new PageEntity(queryParams.getCurrentPage(), queryParams.getPageSize(), totalCount);
				List<UserVo> data = userMapper.selectList(queryParams);
				page.setCurrentPageDatas(data);
				result.setData(page);
			}
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}

	/**
	 *根据Id更新
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public ResponseResult<User> modifyFillById(UserVo userVo){
		ResponseResult<User> result = new ResponseResult<>(TextCode.UPDATE_SUCCESS.text,TextCode.UPDATE_SUCCESS.code);
		try {
			User user = new User();
			BeanUtils.copyProperties(userVo,user);
			user.setRoleId(roleMapper.queryRoleId(userVo.getRoleName()));
			user.setModifyTime(new Date());
			user.setModifyBy(Oauth2Util.getCurrentUser());
			int i = userMapper.updateByPrimaryKey(user);
			if(i != 1){
				result.setResultText(TextCode.UPDATE_FAIL.text);
				result.setResultCode(TextCode.UPDATE_FAIL.code);
				return result;
			}
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}

    /**
	 *插入
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public ResponseResult<Integer> insertFill(UserVo userVo){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		int i = 0;
		try {
			User user = new User();
			BeanUtils.copyProperties(userVo,user);
			user.setRoleId(roleMapper.queryRoleId(userVo.getRoleName()));
			user.setCreateTime(new Date());
			user.setPassword(new BCryptPasswordEncoder().encode(user.getRealPass()));
			user.setCreateBy(Oauth2Util.getCurrentUser());
			//id不为空则更新
			if(null==userVo.getId()){
				i = userMapper.insertFill(user);
			}else {
				i = userMapper.updateByPrimaryKey(user);
			}
			if(i != 1){
				result.setResultText(TextCode.INSERT_FAIL.text);
				result.setResultCode(TextCode.INSERT_FAIL.code);
				return result;
			}
			result.setData(i);
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}


	/**
	 *根据Id删除
	 */
	@Override
	public ResponseResult<Integer> deleteById(Long id){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.DELETE_SUCCESS.text,TextCode.DELETE_SUCCESS.code);
		Integer data = null;
		try {
			data = userMapper.deleteById(id);
			if(data != 1){
				result.setResultText(TextCode.DELETE_FAIL.text);
				result.setResultCode(TextCode.DELETE_FAIL.code);
				return result;
			}
			result.setData(data);
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}

	/**
	 *根据Ids删除
	 */
	@Override
	public ResponseResult<Integer> deleteByIds(Long[] ids){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.DELETE_SUCCESS.text,TextCode.DELETE_SUCCESS.code);
		Integer data = null;
		try {
			data = userMapper.deleteByIds(ids);
			if(data == 0){
				result.setResultText(TextCode.DELETE_FAIL.text);
				result.setResultCode(TextCode.DELETE_FAIL.code);
				return result;
			}
			result.setData(data);
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}


	/**
	 *批量新增
	 */
	@Override
	public ResponseResult<Integer> batchSave(List<User> userList){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		int i = 0;
		try {
			if(null != userList && userList.size() > 0){
				userList.forEach(o -> {
					o.setCreateTime(new Date());
					o.setCreateBy(Oauth2Util.getCurrentUser());
				});
			}
			i = userMapper.batchInsert(userList);
			if(i == 0){
				result.setResultText(TextCode.INSERT_FAIL.text);
				result.setResultCode(TextCode.INSERT_FAIL.code);
				return result;
			}
			result.setData(i);
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}

	@Override
	public ResponseResult<Integer> updateStatusById(Long id) {
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.UPDATE_SUCCESS.text,TextCode.UPDATE_SUCCESS.code);
		try {
			int i = userMapper.updateStatusById(id);
			result.setData(i);
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}

	@Override
	public ResponseResult<List<UserSelectVo>> fetchUser(Long id) {
		ResponseResult<List<UserSelectVo>> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		List<UserSelectVo> data = null;
		try {
			if(null==id){
				result.setResultText(TextCode.SYSTEM_ERROR.text);
				result.setResultCode(TextCode.SYSTEM_ERROR.code);
				return result;
			}
			data = userMapper.fetchUser(id);
			result.setOk(true);
			result.setData(data);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public ResponseResult<UserVo> loginByPass(UserLoginDTO userLoginDTO) {
		ResponseResult<UserVo> result = new ResponseResult<>(BaseTextCode.LOGIN_SUCCESS.text,BaseTextCode.LOGIN_SUCCESS.code);
		UserVo data = new UserVo();
		try {
			User user = userMapper.selectByAccount(userLoginDTO.getUsername());
			if(null == user){
				result.setResultText(BaseTextCode.ACCOUNT_NOT_EXIST.text);
				result.setResultCode(BaseTextCode.ACCOUNT_NOT_EXIST.code);
				return result;
			}
			//bc加密匹配
			BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
			boolean matches = bCrypt.matches(userLoginDTO.getPassword(), user.getPassword());
			if(!matches){
				result.setResultText(BaseTextCode.PASS_NOT_MATCH.text);
				result.setResultCode(BaseTextCode.PASS_NOT_MATCH.code);
				return result;
			}
            //是否被禁用
			if(user.getIsEnable() == 1){
				result.setResultText(BaseTextCode.USER_FORBIDDEN.text);
				result.setResultCode(BaseTextCode.USER_FORBIDDEN.code);
				return result;
			}
			//生成token
			String token = this.getToken(userLoginDTO.getUsername(), userLoginDTO.getPassword());
			if(null == token){
				result.setResultText(TextCode.SYSTEM_ERROR.text);
				result.setResultCode(TextCode.SYSTEM_ERROR.code);
				return result;
			}
			if(user.getNeedRelogin() == 1){
				Integer i  = userMapper.updateLoginStatus(user.getId());
			}
			BeanUtils.copyProperties(user,data);
			String roleName = roleMapper.selectById(user.getRoleId()).getRoleName();
            data.setRoleName(roleName);
			data.setToken(token);
			result.setData(data);
			result.setOk(true);
			return result;
		}catch (Exception e){
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}


	private String getToken(String account, String pass){
		String str = null;
		JSONObject forObject = restTemplate.getForObject("http://localhost:"+serverPort+"/oauth/token?grant_type=password&client_id=web-client&client_secret=secret&username="+account+"&password="+pass, JSONObject.class);
		if(null != forObject){
			str = forObject.getString("access_token");
		}
		return str;
	}

	@Override
	public Integer isReLogin(Long id) {
		return userMapper.selectReLoginStatus(id);
	}
}
