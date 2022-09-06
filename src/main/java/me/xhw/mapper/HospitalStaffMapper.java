package me.xhw.mapper;

import java.util.List;
import java.util.Date;

import me.xhw.entity.vo.HospitalStaffVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.base.entity.query.QueryParams;
import me.xhw.entity.HospitalStaff;

/**
 * @author xhw----2022年08月23日
 */
@Mapper
public interface HospitalStaffMapper {

	List<HospitalStaffVo> selectList(QueryParams<HospitalStaffVo> queryParams);

	HospitalStaff selectById(Long id);

	int selectCount(QueryParams<HospitalStaffVo> queryParams);

	int updateByPrimaryKey(@Param("data")HospitalStaff hospitalStaff);

	int deleteById(Long id);

	int deleteByIds(Long[] ids);

	int insertFill(@Param("data")HospitalStaff hospitalStaff);

	int insertFillReturnId(@Param("data")HospitalStaff hospitalStaff);

	int batchInsert(List<HospitalStaff> hospitalStaffList);
	
}
