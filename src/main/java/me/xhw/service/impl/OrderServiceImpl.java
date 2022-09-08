package me.xhw.service.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import me.xhw.entity.OrderRecord;
import me.xhw.entity.dto.UpdateOrderHandlerDTO;
import me.xhw.entity.vo.OrderVo;
import me.xhw.entity.vo.RecordVo;
import me.xhw.mapper.OrderRecordMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Date;
import me.xhw.entity.Order;
import me.xhw.mapper.OrderMapper;
import me.xhw.service.OrderService;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import com.base.entity.response.TextCode;
import me.xhw.service.OrderService;
import com.base.util.Oauth2Util;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author xhw----2022年08月23日
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	protected Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Resource
	private OrderMapper orderMapper;

	@Resource
	private OrderRecordMapper orderRecordMapper;

	/**
     *查询List
     */
	@Override
	public ResponseResult<List<OrderVo>> queryForList(QueryParams<OrderVo> queryParams){
		ResponseResult<List<OrderVo>> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		List<OrderVo> data = null;
		try {
			data = orderMapper.selectList(queryParams);
			result.setOk(true);
			result.setData(data);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}

	/**
	 *根据Id查询
 	 */
	@Override
	public ResponseResult<Order> queryById(Long id){
		ResponseResult<Order> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		Order data = null;
		try {
			data = orderMapper.selectById(id);
			result.setOk(true);
			result.setData(data);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}


	/**
	 *查询分页
	 */
	@Override
	public ResponseResult<PageEntity> queryForPage(QueryParams<OrderVo> queryParams){
		ResponseResult<PageEntity> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		PageEntity page = null;
		try {
			int totalCount = orderMapper.selectCount(queryParams);
			if(totalCount > 0){
				page = new PageEntity(queryParams.getCurrentPage(), queryParams.getPageSize(), totalCount);
				List<OrderVo> data = orderMapper.selectList(queryParams);
				page.setCurrentPageDatas(data);
				result.setData(page);
			}
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}


	/**
	 *查询已被分配的分页
	 */
	@Override
	public ResponseResult<PageEntity> queryForHandedPage(QueryParams<OrderVo> queryParams){
		ResponseResult<PageEntity> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		PageEntity page = null;
		try {
			int totalCount = orderMapper.selectHandedCount(queryParams);
			if(totalCount > 0){
				page = new PageEntity(queryParams.getCurrentPage(), queryParams.getPageSize(), totalCount);
				List<OrderVo> data = orderMapper.selectHandedList(queryParams);
				page.setCurrentPageDatas(data);
				result.setData(page);
			}
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}

	/**
	 *根据Id更新
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public ResponseResult<Integer> modifyFillById(OrderVo orderVo){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.UPDATE_SUCCESS.text,TextCode.UPDATE_SUCCESS.code);
		try {
			Order order = new Order();
			BeanUtils.copyProperties(orderVo,order);
			order.setModifyTime(new Date());
			order.setModifyBy(Oauth2Util.getCurrentUser());
			int i = orderMapper.updateByPrimaryKey(order);

			if(i != 1){
				result.setResultText(TextCode.UPDATE_FAIL.text);
				result.setResultCode(TextCode.UPDATE_FAIL.code);
				return result;
			}
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}

	@Override
	public ResponseResult<OrderVo> queryOrderById(Long id) {
		ResponseResult<OrderVo> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		try {
			OrderVo orderVo = orderMapper.queryOrderById(id);
			if(null==orderVo){
				result.setResultText(TextCode.UPDATE_FAIL.text);
				result.setResultCode(TextCode.UPDATE_FAIL.code);
				return result;
			}
			result.setData(orderVo);
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}

	/**
	 *根据Id删除
	 */
	@Override
	public ResponseResult<Integer> deleteById(Long id){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.DELETE_SUCCESS.text,TextCode.DELETE_SUCCESS.code);
		Integer data = null;
		try {
			data = orderMapper.deleteById(id);
			if(data != 1){
				result.setResultText(TextCode.DELETE_FAIL.text);
				result.setResultCode(TextCode.DELETE_FAIL.code);
				return result;
			}
			result.setData(data);
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}

	/**
	 *根据Ids删除
	 */
	@Override
	public ResponseResult<Integer> deleteByIds(Long[] ids){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.DELETE_SUCCESS.text,TextCode.DELETE_SUCCESS.code);
		Integer data = null;
		try {
			data = orderMapper.deleteByIds(ids);
			if(data == 0){
				result.setResultText(TextCode.DELETE_FAIL.text);
				result.setResultCode(TextCode.DELETE_FAIL.code);
				return result;
			}
			result.setData(data);
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}


    /**
	 *插入
	 */
	@Override
	public ResponseResult<Integer> insertFill(Order order){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		int i = 0;
		try {
			order.setCreateTime(new Date());
			order.setCreateBy(Oauth2Util.getCurrentUser());
			i = orderMapper.insertFill(order);
			if(i != 1){
				result.setResultText(TextCode.INSERT_FAIL.text);
				result.setResultCode(TextCode.INSERT_FAIL.code);
				return result;
			}
			result.setData(i);
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}

    /**
	 *插入,实体类返回主键
	 */
	@Override
	public ResponseResult<Order> insertFillReturnId(Order order){
		ResponseResult<Order> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		int i = 0;
		try {
			order.setCreateTime(new Date());
			order.setCreateBy(Oauth2Util.getCurrentUser());
			i = orderMapper.insertFillReturnId(order);
			if(i != 1){
				result.setResultText(TextCode.INSERT_FAIL.text);
				result.setResultCode(TextCode.INSERT_FAIL.code);
				return result;
			}
			result.setData(order);
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}

	/**
	 *批量新增
	 */
	@Override
	public ResponseResult<Integer> batchSave(List<Order> orderList){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		int i = 0;
		try {
			if(null != orderList && orderList.size() > 0){
				orderList.forEach(o -> {
					o.setCreateTime(new Date());
					o.setCreateBy(Oauth2Util.getCurrentUser());
				});
			}
			i = orderMapper.batchInsert(orderList);
			if(i == 0){
				result.setResultText(TextCode.INSERT_FAIL.text);
				result.setResultCode(TextCode.INSERT_FAIL.code);
				return result;
			}
			result.setData(i);
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}


	/**
	 * 分配/更新负责人
	 * @param updateOrderHandlerDTO
	 * @return
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public ResponseResult<Integer> updateHandler(UpdateOrderHandlerDTO updateOrderHandlerDTO) {
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.UPDATE_SUCCESS.text,TextCode.UPDATE_SUCCESS.code);
		try {
			Order order = new Order();
			BeanUtils.copyProperties(updateOrderHandlerDTO,order);
			order.setModifyTime(new Date());
			order.setModifyBy(Oauth2Util.getCurrentUser());
			orderMapper.updateByPrimaryKey(order);

			OrderRecord record = new OrderRecord();
			record.setOrderId(updateOrderHandlerDTO.getId());
			record.setHandlerId(updateOrderHandlerDTO.getUserId());
			record.setModifyTime(new Date());
			record.setModifyBy(Oauth2Util.getCurrentUser());
			int i= orderRecordMapper.updateByOrderId(record);

			if(i != 1){
				result.setResultText(TextCode.UPDATE_FAIL.text);
				result.setResultCode(TextCode.UPDATE_FAIL.code);
				return result;
			}
			result.setOk(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}


	@Override
	public ResponseResult<List<RecordVo>> fetchRecord(Long id) {
		ResponseResult<List<RecordVo>> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		List<RecordVo> data = null;
		try {
			data = orderMapper.fetchRecord(id);
			result.setOk(true);
			result.setData(data);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}
}
