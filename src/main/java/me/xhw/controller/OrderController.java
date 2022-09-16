package me.xhw.controller;

import java.util.List;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import me.xhw.entity.Order;
import me.xhw.entity.dto.UpdateOrderHandlerDTO;
import me.xhw.entity.vo.OrderVo;
import me.xhw.entity.vo.RecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import me.xhw.service.OrderService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


/**
 * @author xhw----2022年08月23日
 */
@RestController
@RequestMapping("/order")
@Api(tags="工单管理")
public class OrderController {

	@Autowired
	private OrderService orderService;

//	@PostMapping("/queryForList")
//	@ApiOperation(value = "查询list")
//	public ResponseResult<List<OrderVo>> queryForList(@RequestBody QueryParams<OrderVo> queryParams){
//		return orderService.queryForList(queryParams);
//	}
//
//	@GetMapping("/queryById/{id}")
//	@ApiOperation(value = "根据id查询")
//	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
//	public ResponseResult<Order> queryById(@PathVariable("id")Long id){
//		return orderService.queryById(id);
//	}

	@PostMapping("/queryForPage")
	@ApiOperation(value = "查询分页")
	public ResponseResult<PageEntity> queryForPage(@RequestBody QueryParams<OrderVo> queryParams){
		return orderService.queryForPage(queryParams);
	}

	@PostMapping("/queryForHandedPage")
	@ApiOperation(value = "查询已被分配的分页")
	public ResponseResult<PageEntity> queryForHandedPage(@RequestBody QueryParams<OrderVo> queryParams){
		return orderService.queryForHandedPage(queryParams);
	}

	@PostMapping("/modifyFillById")
	@ApiOperation(value = "根据id修改")
	public ResponseResult<Integer> modifyFillById(@RequestBody OrderVo orderVo){
		return orderService.modifyFillById(orderVo);
	}
	@GetMapping("/queryOrderById/{id}")
	@ApiOperation(value = "根据id获取工单视图对象")
	public ResponseResult<OrderVo> queryOrderById(@PathVariable("id") Long id){
		return orderService.queryOrderById(id);
	}

	@GetMapping("/deleteById/{id}")
	@ApiOperation(value = "根据id删除")
	@ApiImplicitParam(name = "id", value = "数字", required = true, dataType = "Long", paramType = "query")
	public ResponseResult<Integer> deleteById(@PathVariable("id")Long id){
		return orderService.deleteById(id);
	}


	@GetMapping("/fetchRecord/{id}")
	@ApiOperation(value = "根据id查询工单记录")
	public ResponseResult<List<RecordVo>> fetchRecord(@PathVariable("id")Long id){
		return orderService.fetchRecord(id);
	}

	@PostMapping("/deleteByIds")
	@ApiOperation(value = "批量删除")
	public ResponseResult<Integer> deleteByIds(@RequestBody Long[] ids){
		return orderService.deleteByIds(ids);
	}

//	@PostMapping("/insertFill")
//	@ApiOperation(value = "新增")
//	public ResponseResult<Integer> insertFill(@RequestBody Order order){
//		return orderService.insertFill(order);
//	}

	@PostMapping("/updateHandler")
	@ApiOperation(value = "更新工单负责人")
	public ResponseResult<Integer> updateHandler(@RequestBody UpdateOrderHandlerDTO updateOrderHandlerDTO){
		return orderService.updateHandler(updateOrderHandlerDTO);
	}



//	@PostMapping("/insertFillReturnId")
//	@ApiOperation(value = "新增返回主键")
//	public ResponseResult<Order> insertFillReturnId(@RequestBody Order order){
//		return orderService.insertFillReturnId(order);
//	}
//
//	@PostMapping("/batchSave")
//	@ApiOperation(value = "批量新增")
//	public ResponseResult<Integer> batchSave(@RequestBody List<Order> orderList){
//		return 	orderService.batchSave(orderList);
//	}
	
}
