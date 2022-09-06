package me.xhw.mapper;

import java.util.List;
import java.util.Date;

import me.xhw.entity.vo.OfficeSelectVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.base.entity.query.QueryParams;
import me.xhw.entity.HospitalOffice;

/**
 * @author xhw----2022年08月19日
 */
@Mapper
public interface HospitalOfficeMapper {

	List<HospitalOffice> selectList(QueryParams<HospitalOffice> queryParams);

	HospitalOffice selectById(Long id);

	int selectCount(QueryParams<HospitalOffice> queryParams);

	int updateByPrimaryKey(@Param("data")HospitalOffice hospitalOffice);

	int deleteById(Long id);

	int deleteByIds(Long[] ids);

	int insertFill(@Param("data")HospitalOffice hospitalOffice);

	int insertFillReturnId(@Param("data")HospitalOffice hospitalOffice);

	int batchInsert(List<HospitalOffice> hospitalOfficeList);

    List<OfficeSelectVo> fetchName(Long id);

}
