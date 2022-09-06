package me.xhw.service;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Order;
import me.xhw.entity.dto.UpdateOrderHandlerDTO;
import me.xhw.entity.vo.OrderVo;
import me.xhw.entity.vo.RecordVo;

/**
 * @author xhw----2022年08月23日
 */
public interface OrderService {

	ResponseResult<List<OrderVo>> queryForList(QueryParams<OrderVo> queryParams);

	ResponseResult<Order> queryById(Long id);

	ResponseResult<PageEntity> queryForPage(QueryParams<OrderVo> queryParams);

	ResponseResult<PageEntity> queryForHandedPage(QueryParams<OrderVo> queryParams);

	ResponseResult<Integer> modifyFillById(OrderVo orderVo);

	ResponseResult<Integer> deleteById(Long id);

	ResponseResult<Integer> deleteByIds(Long[] ids);

	ResponseResult<Integer> insertFill(Order order);

	ResponseResult<Order> insertFillReturnId(Order order);

	ResponseResult<Integer> batchSave(List<Order> orderList);

    ResponseResult<Integer> updateHandler(UpdateOrderHandlerDTO updateOrderHandlerDTO);

    ResponseResult<List<RecordVo>> fetchRecord(Long id);

    ResponseResult<OrderVo> queryOrderById(Long id);
}
