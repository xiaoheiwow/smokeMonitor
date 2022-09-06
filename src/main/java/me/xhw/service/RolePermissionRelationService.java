package me.xhw.service;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.RolePermissionRelation;

/**
 * @author xhw----2022年08月29日
 */
public interface RolePermissionRelationService {

	ResponseResult<List<RolePermissionRelation>> queryForList(QueryParams<RolePermissionRelation> queryParams);

	ResponseResult<RolePermissionRelation> queryById(Long id);

	ResponseResult<PageEntity> queryForPage(QueryParams<RolePermissionRelation> queryParams);

	ResponseResult<RolePermissionRelation> modifyFillById(RolePermissionRelation rolePermissionRelation);

	ResponseResult<Integer> deleteById(Long id);

	ResponseResult<Integer> deleteByIds(Long[] ids);

	ResponseResult<Integer> insertFill(RolePermissionRelation rolePermissionRelation);

	ResponseResult<RolePermissionRelation> insertFillReturnId(RolePermissionRelation rolePermissionRelation);

	ResponseResult<Integer> batchSave(List<RolePermissionRelation> rolePermissionRelationList);
	
}
