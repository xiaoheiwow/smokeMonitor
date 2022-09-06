package me.xhw.mapper;

import java.util.List;
import java.util.Date;

import me.xhw.entity.vo.InspectorVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Inspector;

/**
 * @author xhw----2022年08月22日
 */
@Mapper
public interface InspectorMapper {

	List<InspectorVo> selectList(QueryParams<InspectorVo> queryParams);

	Inspector selectById(Long id);

	int selectCount(QueryParams<InspectorVo> queryParams);

	int updateByPrimaryKey(@Param("data")Inspector inspector);

	int deleteById(Long id);

	int deleteByIds(Long[] ids);

	int insertFill(@Param("data")Inspector inspector);

	int insertFillReturnId(@Param("data")Inspector inspector);

	int batchInsert(List<Inspector> inspectorList);

    int banInspectorById(Long id);
}
