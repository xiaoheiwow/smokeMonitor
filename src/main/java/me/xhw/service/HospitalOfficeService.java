package me.xhw.service;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.HospitalOffice;
import me.xhw.entity.vo.OfficeSelectVo;

/**
 * @author xhw----2022年08月19日
 */
public interface HospitalOfficeService {

	ResponseResult<List<HospitalOffice>> queryForList(QueryParams<HospitalOffice> queryParams);

	ResponseResult<HospitalOffice> queryById(Long id);

	ResponseResult<PageEntity> queryForPage(QueryParams<HospitalOffice> queryParams);

	ResponseResult<HospitalOffice> modifyFillById(HospitalOffice hospitalOffice);

	ResponseResult<Integer> deleteById(Long id);

	ResponseResult<Integer> deleteByIds(Long[] ids);

	ResponseResult<Integer> insertFill(HospitalOffice hospitalOffice);

	ResponseResult<HospitalOffice> insertFillReturnId(HospitalOffice hospitalOffice);

	ResponseResult<Integer> batchSave(List<HospitalOffice> hospitalOfficeList);

    ResponseResult<List<OfficeSelectVo>> fetchName(Long id);
}
