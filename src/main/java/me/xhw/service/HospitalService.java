package me.xhw.service;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Hospital;
import me.xhw.entity.vo.HospitalListVo;
import me.xhw.entity.vo.HospitalSelectVo;

/**
 * @author xhw----2022年08月16日
 */
public interface HospitalService {

	ResponseResult<List<HospitalListVo>> queryForList(QueryParams<HospitalListVo> queryParams);

	ResponseResult<Hospital> queryById(Long id);

	ResponseResult<PageEntity> queryForPage(QueryParams<HospitalListVo> queryParams);

	ResponseResult<Hospital> modifyFillById(Hospital hospital);

	ResponseResult<Integer> deleteById(Long id);

	ResponseResult<Integer> deleteByIds(Long[] ids);

	ResponseResult<Integer> insertFill(Hospital hospital);

	ResponseResult<Hospital> insertFillReturnId(Hospital hospital);

	ResponseResult<Integer> batchSave(List<Hospital> hospitalList);

	ResponseResult<List<String>> fetchLevel();

	ResponseResult<List<String>> fetchRegion();

    ResponseResult<List<HospitalSelectVo>> fetchName();
}
