package me.xhw.service.impl;

import me.xhw.entity.vo.PermissionVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import me.xhw.entity.Permission;
import me.xhw.mapper.PermissionMapper;
import me.xhw.service.PermissionService;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import com.base.entity.response.TextCode;
import com.base.util.Oauth2Util;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author xhw----2022年08月19日
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{
	
	protected Logger log = LoggerFactory.getLogger(PermissionServiceImpl.class);
	
	@Resource
	private PermissionMapper permissionMapper;


	/**
	 *查询权限列表
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public ResponseResult<List<PermissionVo>> getPermissionList() {
		ResponseResult<List<PermissionVo>> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		List<Permission> list =  permissionMapper.selectPermissionList();
		List<PermissionVo> data = new ArrayList<PermissionVo>();
		//筛选一层权限
		for (Permission permission : list) {
			PermissionVo storage = new PermissionVo();
			if(permission.getParentId()==0){
				storage.setId(permission.getId());
				storage.setPermissionName(permission.getPermissionName());
				storage.setChildren(new ArrayList<PermissionVo>());
				data.add(storage);
			}
		}
        //筛选子权限
		for (Permission permission : list) {
			Long parentId = permission.getParentId();
			for (PermissionVo vo : data) {
				PermissionVo storage = new PermissionVo();
				if(vo.getId().equals(parentId)){
					storage.setId(permission.getId());
					storage.setPermissionName(permission.getPermissionName());
					vo.getChildren().add(storage);
				}
			}
		}
		result.setOk(true);
		result.setData(data);
		return result;
	}




	/**
     *查询List
     */
	@Override
	public ResponseResult<List<Permission>> queryForList(QueryParams<Permission> queryParams){
		ResponseResult<List<Permission>> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		List<Permission> datas = null;
		try {
			datas = permissionMapper.selectList(queryParams);
			result.setOk(true);
			result.setData(datas);
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
	public ResponseResult<Permission> queryById(Long id){
		ResponseResult<Permission> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		Permission data = null;
		try {
			data = permissionMapper.selectById(id);
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
	public ResponseResult<PageEntity> queryForPage(QueryParams<Permission> queryParams){
		ResponseResult<PageEntity> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		PageEntity page = null;
		try {
			int totalCount = permissionMapper.selectCount(queryParams);
			if(totalCount > 0){
				page = new PageEntity(queryParams.getCurrentPage(), queryParams.getPageSize(), totalCount);
				List<Permission> datas = permissionMapper.selectList(queryParams);
				page.setCurrentPageDatas(datas);
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
	public ResponseResult<Permission> modifyFillById(Permission permission){
		ResponseResult<Permission> result = new ResponseResult<>(TextCode.UPDATE_SUCCESS.text,TextCode.UPDATE_SUCCESS.code);
		try {
			permission.setModifyTime(new Date());
			permission.setModifyBy(Oauth2Util.getCurrentUser());
			int i = permissionMapper.updateByPrimaryKey(permission);
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
	 *根据Id删除
	 */
	@Override
	public ResponseResult<Integer> deleteById(Long id){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.DELETE_SUCCESS.text,TextCode.DELETE_SUCCESS.code);
		Integer data = null;
		try {
			data = permissionMapper.deleteById(id);
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
			data = permissionMapper.deleteByIds(ids);
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
	 *插入
	 */
	@Override
	public ResponseResult<Integer> insertFill(Permission permission){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		int i = 0;
		try {
			permission.setCreateTime(new Date());
			permission.setCreateBy(Oauth2Util.getCurrentUser());
			i = permissionMapper.insertFill(permission);
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
	 *插入,实体类返回主键
	 */
	@Override
	public ResponseResult<Permission> insertFillReturnId(Permission permission){
		ResponseResult<Permission> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		int i = 0;
		try {
			permission.setCreateTime(new Date());
			permission.setCreateBy(Oauth2Util.getCurrentUser());
			i = permissionMapper.insertFillReturnId(permission);
			if(i != 1){
				result.setResultText(TextCode.INSERT_FAIL.text);
				result.setResultCode(TextCode.INSERT_FAIL.code);
				return result;
			}
			result.setData(permission);
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
	public ResponseResult<Integer> batchSave(List<Permission> permissionList){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		int i = 0;
		try {
			if(null != permissionList && permissionList.size() > 0){
				permissionList.forEach(o -> {
					o.setCreateTime(new Date());
					o.setCreateBy(Oauth2Util.getCurrentUser());
				});
			}
			i = permissionMapper.batchInsert(permissionList);
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
}
