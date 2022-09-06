package me.xhw.service;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Role;
import me.xhw.entity.dto.AddRoleDTO;
import me.xhw.entity.vo.RoleSelectVo;

/**
 * @author xhw----2022年08月19日
 */
public interface RoleService {

	ResponseResult<List<Role>> queryForList(QueryParams<Role> queryParams);

	ResponseResult<PageEntity> queryForPage(QueryParams<Role> queryParams);

	ResponseResult<Role> modifyFillById(Role role);

	ResponseResult<Integer> deleteById(Long id);


	ResponseResult<Integer> deleteByIds(Long[] ids);

	ResponseResult<Integer> insertRoleAndPermission(AddRoleDTO addRoleDTO);

	ResponseResult<Role> insertFillReturnId(Role role);

	ResponseResult<Integer> batchSave(List<Role> roleList);

    ResponseResult<List<RoleSelectVo>> fetchRoleName();
}
