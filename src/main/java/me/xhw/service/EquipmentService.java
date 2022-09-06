package me.xhw.service;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Equipment;
import me.xhw.entity.vo.EquipmentVo;
import me.xhw.entity.vo.SimpleEquipVo;

/**
 * @author xhw----2022年08月16日
 */
public interface EquipmentService {

	ResponseResult<List<EquipmentVo>> queryForList(QueryParams<EquipmentVo> queryParams);

	ResponseResult<Equipment> queryById(Long id);

	ResponseResult<PageEntity> queryForPage(QueryParams<EquipmentVo> queryParams);

	ResponseResult<Equipment> modifyFillById(Equipment equipment);

	ResponseResult<Integer> deleteById(Long id);

	ResponseResult<Integer> deleteByIds(Long[] ids);

	ResponseResult<Integer> insertFill(Equipment equipment);

	ResponseResult<Equipment> insertFillReturnId(Equipment equipment);

	ResponseResult<Integer> batchSave(List<Equipment> equipmentList);


    ResponseResult<List<SimpleEquipVo>> queryListByHospitalId(Long id);

	ResponseResult<Integer> batchUpdate(List<Equipment> equipmentList);

    ResponseResult<Integer> updateStatusById(Long id);
}
