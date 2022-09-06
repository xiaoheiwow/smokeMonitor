package me.xhw.mapper;

import java.util.List;
import java.util.Date;

import me.xhw.entity.vo.HospitalListVo;
import me.xhw.entity.vo.HospitalSelectVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Hospital;

/**
 * @author xhw----2022年08月16日
 */
@Mapper
public interface HospitalMapper {

	List<HospitalListVo> selectList(QueryParams<HospitalListVo> queryParams);

	Hospital selectById(Long id);

	int selectCount(QueryParams<HospitalListVo> queryParams);

	int updateByPrimaryKey(@Param("data")Hospital hospital);

	int deleteById(Long id);

	int deleteByIds(Long[] ids);

	int insertFill(@Param("data")Hospital hospital);

	int insertFillReturnId(@Param("data")Hospital hospital);

	int batchInsert(List<Hospital> hospitalList);

	List<String> fetchLevel();

	List<String> fetchRegion();

	List<HospitalSelectVo> fetchName();
}
