package me.xhw.service;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.HospitalStaff;
import me.xhw.entity.dto.HospitalStaffUpdateDTO;
import me.xhw.entity.dto.StaffSimpleQueryDTO;
import me.xhw.entity.vo.HospitalStaffVo;

/**
 * @author xhw----2022年08月23日
 */
public interface HospitalStaffService {

	ResponseResult<List<HospitalStaffVo>> queryForList(QueryParams<HospitalStaffVo> queryParams);

	ResponseResult<HospitalStaff> queryById(Long id);

	ResponseResult<PageEntity> queryForPage(QueryParams<HospitalStaffVo> queryParams);

	ResponseResult<Integer> modifyFillById(HospitalStaffUpdateDTO hospitalStaffUpdateDTO);

	ResponseResult<Integer> deleteById(Long id);

	ResponseResult<Integer> deleteByIds(Long[] ids);

	ResponseResult<Long> insertFill(HospitalStaffUpdateDTO hospitalStaffUpdateDTO);

	ResponseResult<HospitalStaff> insertFillReturnId(HospitalStaff hospitalStaff);

	ResponseResult<Integer> batchSave(List<HospitalStaff> hospitalStaffList);

}
