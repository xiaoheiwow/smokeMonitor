package me.xhw.service;

import java.util.List;

import com.base.entity.query.QueryParams;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import me.xhw.entity.User;
import me.xhw.entity.dto.UserLoginDTO;
import me.xhw.entity.vo.UserSelectVo;
import me.xhw.entity.vo.UserVo;

/**
 * @author xhw----2022年08月16日
 */
public interface UserService {

	ResponseResult<List<UserVo>> queryForList(QueryParams<UserVo> queryParams);

	ResponseResult<User> queryById(Long id);

	ResponseResult<PageEntity> queryForPage(QueryParams<UserVo> queryParams);

	ResponseResult<User> modifyFillById(UserVo userVo);

	ResponseResult<Integer> deleteById(Long id);

	ResponseResult<Integer> deleteByIds(Long[] ids);

	ResponseResult<Integer> insertFill(UserVo userVo);


	ResponseResult<Integer> batchSave(List<User> userList);

    Integer isReLogin(Long valueOf);

    ResponseResult<Integer> updateStatusById(Long id);

    ResponseResult<List<UserSelectVo>> fetchUser(Long id);

    ResponseResult<UserVo> loginByPass(UserLoginDTO userLoginDTO );
}
