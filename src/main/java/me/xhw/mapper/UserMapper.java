package me.xhw.mapper;

import java.util.List;

import me.xhw.entity.vo.UserSelectVo;
import me.xhw.entity.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.base.entity.query.QueryParams;
import me.xhw.entity.User;

/**
 * @author xhw----2022年08月16日
 */
@Mapper
public interface UserMapper {

	List<UserVo> selectList(QueryParams<UserVo> queryParams);

	User selectById(Long id);

	int selectCount(QueryParams<UserVo> queryParams);

	int updateByPrimaryKey(@Param("data")User user);

	int deleteById(Long id);

	int deleteByIds(Long[] ids);

	int insertFill(@Param("data")User user);

	int insertFillReturnId(@Param("data")User user);

	int batchInsert(List<User> userList);

	Integer selectReLoginStatus(Long id);

	User selectByAccount(String name);

    int updateStatusById(Long id);

    List<UserSelectVo> fetchUser(Long id);

	Integer updateLoginStatus(Long id);
}
