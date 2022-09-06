package me.xhw.mapper;

import java.util.List;
import java.util.Date;

import me.xhw.entity.vo.EquipLocationVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.base.entity.query.QueryParams;
import me.xhw.entity.HospitalEquipLocation;

/**
 * @author xhw----2022年08月18日
 */
@Mapper
public interface HospitalEquipLocationMapper {

	List<EquipLocationVo> selectList(QueryParams<EquipLocationVo> queryParams);

	HospitalEquipLocation selectById(Long id);

	int selectCount(QueryParams<EquipLocationVo> queryParams);

	int updateByPrimaryKey(@Param("data")HospitalEquipLocation hospitalEquipLocation);

	int deleteById(Long id);

	int deleteByIds(Long[] ids);

	int insertFill(@Param("data")HospitalEquipLocation hospitalEquipLocation);

	int insertFillReturnId(@Param("data")HospitalEquipLocation hospitalEquipLocation);

	int batchInsert(List<HospitalEquipLocation> hospitalEquipLocationList);
	
}
