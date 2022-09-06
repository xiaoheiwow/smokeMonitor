package me.xhw.service;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.HospitalBuilding;
import me.xhw.entity.vo.BuildingVo;

/**
 * @author xhw----2022年08月17日
 */
public interface HospitalBuildingService {

	ResponseResult<List<BuildingVo>> queryForList(QueryParams<BuildingVo> queryParams);

	ResponseResult<HospitalBuilding> queryById(Long id);

	ResponseResult<PageEntity> queryForPage(QueryParams<BuildingVo> queryParams);

	ResponseResult<HospitalBuilding> modifyFillById(HospitalBuilding hospitalBuilding);

	ResponseResult<Integer> deleteById(Long id);

	ResponseResult<Integer> deleteByIds(Long[] ids);

	ResponseResult<Integer> insertFill(HospitalBuilding hospitalBuilding);

	ResponseResult<HospitalBuilding> insertFillReturnId(HospitalBuilding hospitalBuilding);

	ResponseResult<Integer> batchSave(List<HospitalBuilding> hospitalBuildingList);
	
}
