package me.xhw.service;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Inspector;
import me.xhw.entity.vo.InspectorVo;

/**
 * @author xhw----2022年08月22日
 */
public interface InspectorService {

	ResponseResult<List<InspectorVo>> queryForList(QueryParams<InspectorVo> queryParams);

	ResponseResult<Inspector> queryById(Long id);

	ResponseResult<PageEntity> queryForPage(QueryParams<InspectorVo> queryParams);

	ResponseResult<Inspector> modifyFillById(InspectorVo inspectorVo);

	ResponseResult<Integer> deleteById(Long id);

	ResponseResult<Integer> deleteByIds(Long[] ids);

	ResponseResult<Long> insertFill(InspectorVo inspectorVo);

	ResponseResult<Inspector> insertFillReturnId(Inspector inspector);

	ResponseResult<Integer> batchSave(List<Inspector> inspectorList);

	ResponseResult<Integer> banInspectorById(Long id);
}
