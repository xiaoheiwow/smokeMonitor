package me.xhw.mapper;

import java.util.List;
import java.util.Date;

import me.xhw.entity.vo.OrderVo;
import me.xhw.entity.vo.RecordVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Order;

/**
 * @author xhw----2022年08月23日
 */
@Mapper
public interface OrderMapper {

	List<OrderVo> selectList(QueryParams<OrderVo> queryParams);

	List<OrderVo> selectHandedList(QueryParams<OrderVo> queryParams);

	Order selectById(Long id);

	int selectCount(QueryParams<OrderVo> queryParams);

	int updateByPrimaryKey(@Param("data")Order order);

	int deleteById(Long id);

	int deleteByIds(Long[] ids);

	int insertFill(@Param("data")Order order);

	int insertFillReturnId(@Param("data")Order order);

	int batchInsert(List<Order> orderList);

	int selectHandedCount(QueryParams<OrderVo> queryParams);

    List<RecordVo> fetchRecord(Long id);

    OrderVo queryOrderById(Long id);
}
