package me.xhw.mapper;

import java.util.List;
import java.util.Date;

import me.xhw.entity.vo.BuildingVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.base.entity.query.QueryParams;
import me.xhw.entity.HospitalBuilding;

/**
 * @author xhw----2022年08月17日
 */
@Mapper
public interface HospitalBuildingMapper {

	List<BuildingVo> selectList(QueryParams<BuildingVo> queryParams);

	HospitalBuilding selectById(Long id);

	int selectCount(QueryParams<BuildingVo> queryParams);

	int updateByPrimaryKey(@Param("data")HospitalBuilding hospitalBuilding);

	int deleteById(Long id);

	int deleteByIds(Long[] ids);

	int insertFill(@Param("data")HospitalBuilding hospitalBuilding);

	int insertFillReturnId(@Param("data")HospitalBuilding hospitalBuilding);

	int batchInsert(List<HospitalBuilding> hospitalBuildingList);
	
}
