package me.xhw.service.impl;

import me.xhw.entity.Permission;
import me.xhw.entity.RolePermissionRelation;
import me.xhw.entity.dto.AddRoleDTO;
import me.xhw.entity.vo.RoleSelectVo;
import me.xhw.mapper.PermissionMapper;
import me.xhw.mapper.RolePermissionRelationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import me.xhw.entity.Role;
import me.xhw.mapper.RoleMapper;
import me.xhw.service.RoleService;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import com.base.entity.response.TextCode;
import com.base.util.Oauth2Util;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author xhw----2022年08月19日
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{
	
	protected Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Resource
	private RoleMapper roleMapper;
	
	@Resource
	private RolePermissionRelationMapper rolePermissionRelationMapper;

	@Resource
	private PermissionMapper permissionMapper;

	/**
     *查询List
     */
	@Override
	public ResponseResult<List<Role>> queryForList(QueryParams<Role> queryParams){
		ResponseResult<List<Role>> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		List<Role> datas = null;
		try {
			datas = roleMapper.selectList(queryParams);
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
	 *查询分页
	 */
	@Override
	public ResponseResult<PageEntity> queryForPage(QueryParams<Role> queryParams){
		ResponseResult<PageEntity> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		PageEntity page = null;
		try {
			int totalCount = roleMapper.selectCount(queryParams);
			if(totalCount > 0){
				page = new PageEntity(queryParams.getCurrentPage(), queryParams.getPageSize(), totalCount);
				List<Role> data = roleMapper.selectList(queryParams);
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
	public ResponseResult<Role> modifyFillById(Role role){
		ResponseResult<Role> result = new ResponseResult<>(TextCode.UPDATE_SUCCESS.text,TextCode.UPDATE_SUCCESS.code);
		try {
			role.setModifyTime(new Date());
			role.setModifyBy(Oauth2Util.getCurrentUser());
			int i = roleMapper.updateByPrimaryKey(role);
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
			data = roleMapper.deleteById(id);
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
			data = roleMapper.deleteByIds(ids);
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
	 * 插入角色表及角色权限关系表
	 * @param addRoleDTO 角色添加传输对象
	 * @return 插入行数
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public ResponseResult<Integer> insertRoleAndPermission(AddRoleDTO addRoleDTO){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		int i = 0,j = -1;
		try {
			//插入角色表并返回主键
			Role role = new Role();
			role.setRoleName(addRoleDTO.getRoleName());
			role.setCreateTime(new Date());
			role.setCreateBy(Oauth2Util.getCurrentUser());
			i = roleMapper.insertFillReturnId(role);

			//筛选一层权限 删除多余子权限
			Long[] permissions = addRoleDTO.getPermissions();
			List<Long> arrList = Arrays.asList(permissions);
			List<Long> permissionList = new ArrayList(arrList);
			List<Permission> list =  permissionMapper.selectPermissionList();
			Long[] ids =null;
			for (Permission permission : list) {
				if(permission.getParentId()==0 && permissionList.contains(permission.getId())){
					ids = permissionMapper.selectSubId(permission.getId());
				}
			}
			if(ids!=null){
				for (Long id : ids) {
					permissionList.remove(id);
				}
			}
			//批量插入关系表
			List<RolePermissionRelation> rolePermissionRelations = new ArrayList<RolePermissionRelation>();
			for (Long per : permissionList) {
				RolePermissionRelation relation = new RolePermissionRelation();
				relation.setRoleId(role.getId());
				relation.setPermissionId(per);
				rolePermissionRelations.add(relation);
			}
			j = rolePermissionRelationMapper.batchInsert(rolePermissionRelations);
			if(i != 1 && j>=0){
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
	public ResponseResult<Role> insertFillReturnId(Role role){
		ResponseResult<Role> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		int i = 0;
		try {
			role.setCreateTime(new Date());
			role.setCreateBy(Oauth2Util.getCurrentUser());
			i = roleMapper.insertFillReturnId(role);
			if(i != 1){
				result.setResultText(TextCode.INSERT_FAIL.text);
				result.setResultCode(TextCode.INSERT_FAIL.code);
				return result;
			}
			result.setData(role);
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
	public ResponseResult<Integer> batchSave(List<Role> roleList){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		int i = 0;
		try {
			if(null != roleList && roleList.size() > 0){
				roleList.forEach(o -> {
					o.setCreateTime(new Date());
					o.setCreateBy(Oauth2Util.getCurrentUser());
				});
			}
			i = roleMapper.batchInsert(roleList);
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
	public ResponseResult<List<RoleSelectVo>> fetchRoleName() {
		ResponseResult<List<RoleSelectVo>> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		List<RoleSelectVo> data = null;
		try {
			data = roleMapper.fetchName();
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
}
