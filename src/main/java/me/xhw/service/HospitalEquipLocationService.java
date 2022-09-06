package me.xhw.service;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.HospitalEquipLocation;
import me.xhw.entity.vo.EquipLocationVo;

/**
 * @author xhw----2022年08月18日
 */
public interface HospitalEquipLocationService {

	ResponseResult<List<EquipLocationVo>> queryForList(QueryParams<EquipLocationVo> queryParams);

	ResponseResult<HospitalEquipLocation> queryById(Long id);

	ResponseResult<PageEntity> queryForPage(QueryParams<EquipLocationVo> queryParams);

	ResponseResult<HospitalEquipLocation> modifyFillById(HospitalEquipLocation hospitalEquipLocation);

	ResponseResult<Integer> deleteById(Long id);

	ResponseResult<Integer> deleteByIds(Long[] ids);

	ResponseResult<Integer> insertFill(HospitalEquipLocation hospitalEquipLocation);

	ResponseResult<HospitalEquipLocation> insertFillReturnId(HospitalEquipLocation hospitalEquipLocation);

	ResponseResult<Integer> batchSave(List<HospitalEquipLocation> hospitalEquipLocationList);
	
}
