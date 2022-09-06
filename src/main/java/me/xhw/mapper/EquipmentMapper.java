package me.xhw.mapper;

import java.util.List;
import java.util.Date;

import me.xhw.entity.vo.EquipmentVo;
import me.xhw.entity.vo.SimpleEquipVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Equipment;

/**
 * @author xhw----2022年08月16日
 */
@Mapper
public interface EquipmentMapper {

	List<EquipmentVo> selectList(QueryParams<EquipmentVo> queryParams);

	Equipment selectById(Long id);

	int selectCount(QueryParams<EquipmentVo> queryParams);

	int updateByPrimaryKey(@Param("data")Equipment equipment);

	int deleteById(Long id);

	int deleteByIds(Long[] ids);

	int insertFill(@Param("data")Equipment equipment);

	int insertFillReturnId(@Param("data")Equipment equipment);

	int batchInsert(List<Equipment> equipmentList);

    List<SimpleEquipVo> queryListByHospitalId(Long id);

    int updateStatusById(Long id);
}
