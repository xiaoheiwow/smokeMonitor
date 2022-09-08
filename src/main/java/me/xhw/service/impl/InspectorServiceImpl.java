package me.xhw.service.impl;

import me.xhw.entity.User;
import me.xhw.entity.vo.InspectorVo;
import me.xhw.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Date;
import me.xhw.entity.Inspector;
import me.xhw.mapper.InspectorMapper;
import me.xhw.service.InspectorService;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import com.base.entity.response.TextCode;
import me.xhw.service.InspectorService;
import com.base.util.Oauth2Util;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author xhw----2022年08月22日
 */
@Service("inspectorService")
public class InspectorServiceImpl implements InspectorService{
	
	protected Logger log = LoggerFactory.getLogger(InspectorServiceImpl.class);
	
	@Resource
	private InspectorMapper inspectorMapper;

	@Resource
	private UserMapper userMapper;

	/**
     *查询List
     */
	@Override
	public ResponseResult<List<InspectorVo>> queryForList(QueryParams<InspectorVo> queryParams){
		ResponseResult<List<InspectorVo>> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		List<InspectorVo> data = null;
		try {
			data = inspectorMapper.selectList(queryParams);
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
	public ResponseResult<Inspector> queryById(Long id){
		ResponseResult<Inspector> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		Inspector data = null;
		try {
			data = inspectorMapper.selectById(id);
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
	public ResponseResult<PageEntity> queryForPage(QueryParams<InspectorVo> queryParams){
		ResponseResult<PageEntity> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		PageEntity page = null;
		try {
			int totalCount = inspectorMapper.selectCount(queryParams);
			if(totalCount > 0){
				page = new PageEntity(queryParams.getCurrentPage(), queryParams.getPageSize(), totalCount);
				List<InspectorVo> data = inspectorMapper.selectList(queryParams);
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
	public ResponseResult<Inspector> modifyFillById(InspectorVo inspectorVo){
		ResponseResult<Inspector> result = new ResponseResult<>(TextCode.UPDATE_SUCCESS.text,TextCode.UPDATE_SUCCESS.code);
		try {
			//更新巡查人员表
			Inspector inspector = new Inspector();
			BeanUtils.copyProperties(inspectorVo,inspector);
			inspector.setModifyTime(new Date());
			inspector.setModifyBy(Oauth2Util.getCurrentUser());
			int i = inspectorMapper.updateByPrimaryKey(inspector);

			//更新用户表
			User user = new User();
			BeanUtils.copyProperties(inspectorVo,user);
			Long userId = inspectorMapper.selectById(inspectorVo.getId()).getUserId();
			user.setId(userId);
			user.setModifyTime(new Date());
			user.setModifyBy(Oauth2Util.getCurrentUser());
			userMapper.updateByPrimaryKey(user);
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

	/**
	 * 插入
	 * @param inspectorVo
	 * @return 新增user的主键ID
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public ResponseResult<Long> insertFill(InspectorVo inspectorVo){
		ResponseResult<Long> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		try {
			//新建空用户 返回主键
			User user = new User();
			userMapper.insertFillReturnId(user);
			//插入巡查人员
			Inspector inspector = new Inspector();
			BeanUtils.copyProperties(inspectorVo,inspector);
			inspector.setLastTime(new Date());
			inspector.setIsBanned(0);
			inspector.setUserId(user.getId());
			inspector.setLoginTimes("0");
			inspector.setCreateTime(new Date());
			inspector.setCreateBy(Oauth2Util.getCurrentUser());
			int i = inspectorMapper.insertFill(inspector);
			if(i != 1){
				result.setResultText(TextCode.INSERT_FAIL.text);
				result.setResultCode(TextCode.INSERT_FAIL.code);
				return result;
			}
			result.setData(user.getId());
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
			data = inspectorMapper.deleteById(id);
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
			data = inspectorMapper.deleteByIds(ids);
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
	 *插入,实体类返回主键
	 */
	@Override
	public ResponseResult<Inspector> insertFillReturnId(Inspector inspector){
		ResponseResult<Inspector> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		int i = 0;
		try {
			inspector.setCreateTime(new Date());
			inspector.setCreateBy(Oauth2Util.getCurrentUser());
			i = inspectorMapper.insertFillReturnId(inspector);
			if(i != 1){
				result.setResultText(TextCode.INSERT_FAIL.text);
				result.setResultCode(TextCode.INSERT_FAIL.code);
				return result;
			}
			result.setData(inspector);
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
	public ResponseResult<Integer> batchSave(List<Inspector> inspectorList){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		int i = 0;
		try {
			if(null != inspectorList && inspectorList.size() > 0){
				inspectorList.forEach(o -> {
					o.setCreateTime(new Date());
					o.setCreateBy(Oauth2Util.getCurrentUser());
				});
			}
			i = inspectorMapper.batchInsert(inspectorList);
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
	 * 更新禁用状态
	 * @param id
	 */
	@Override
	public ResponseResult<Integer> banInspectorById(Long id) {
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		Inspector data = null;
		try {
			int i = inspectorMapper.banInspectorById(id);
			result.setOk(true);
			result.setData(i);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultText(TextCode.SYSTEM_ERROR.text);
			result.setResultCode(TextCode.SYSTEM_ERROR.code);
			return result;
		}
	}
}
