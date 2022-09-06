package me.xhw.service;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Permission;
import me.xhw.entity.vo.PermissionVo;

/**
 * @author xhw----2022年08月19日
 */
public interface PermissionService {

	ResponseResult<List<Permission>> queryForList(QueryParams<Permission> queryParams);

	ResponseResult<Permission> queryById(Long id);

	ResponseResult<PageEntity> queryForPage(QueryParams<Permission> queryParams);

	ResponseResult<Permission> modifyFillById(Permission permission);

	ResponseResult<Integer> deleteById(Long id);

	ResponseResult<Integer> deleteByIds(Long[] ids);

	ResponseResult<Integer> insertFill(Permission permission);

	ResponseResult<Permission> insertFillReturnId(Permission permission);

	ResponseResult<Integer> batchSave(List<Permission> permissionList);


	ResponseResult<List<PermissionVo>> getPermissionList();



}
