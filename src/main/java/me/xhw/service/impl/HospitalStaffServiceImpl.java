package me.xhw.service.impl;

import me.xhw.entity.User;
import me.xhw.entity.dto.HospitalStaffUpdateDTO;
import me.xhw.entity.dto.StaffSimpleQueryDTO;
import me.xhw.entity.vo.HospitalStaffVo;
import me.xhw.mapper.DepartmentMapper;
import me.xhw.mapper.HospitalOfficeMapper;
import me.xhw.mapper.UserMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Date;
import me.xhw.entity.HospitalStaff;
import me.xhw.mapper.HospitalStaffMapper;
import me.xhw.service.HospitalStaffService;
import com.base.entity.response.ResponseResult;
import com.base.entity.page.PageEntity;
import com.base.entity.query.QueryParams;
import com.base.entity.response.TextCode;
import com.base.util.Oauth2Util;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author xhw----2022年08月23日
 */
@Service("hospitalStaffService")
public class HospitalStaffServiceImpl implements HospitalStaffService{
	
	protected Logger log = LoggerFactory.getLogger(HospitalStaffServiceImpl.class);
	
	@Resource
	private HospitalStaffMapper hospitalStaffMapper;

	@Resource
	private UserMapper userMapper;


	/**
     *查询List
     */
	@Override
	public ResponseResult<List<HospitalStaffVo>> queryForList(QueryParams<HospitalStaffVo> queryParams){
		ResponseResult<List<HospitalStaffVo>> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		List<HospitalStaffVo> data = null;
		try {
			data = hospitalStaffMapper.selectList(queryParams);
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
	public ResponseResult<HospitalStaff> queryById(Long id){
		ResponseResult<HospitalStaff> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		HospitalStaff data = null;
		try {
			data = hospitalStaffMapper.selectById(id);
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
	public ResponseResult<PageEntity> queryForPage(QueryParams<HospitalStaffVo> queryParams){
		ResponseResult<PageEntity> result = new ResponseResult<>(TextCode.RESPONSE_SUCCESS.text,TextCode.RESPONSE_SUCCESS.code);
		PageEntity page = null;
		try {
			int totalCount = hospitalStaffMapper.selectCount(queryParams);
			if(totalCount > 0){
				page = new PageEntity(queryParams.getCurrentPage(), queryParams.getPageSize(), totalCount);
				List<HospitalStaffVo> data = hospitalStaffMapper.selectList(queryParams);
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
	public ResponseResult<Integer> modifyFillById(HospitalStaffUpdateDTO hospitalStaffUpdateDTO){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.UPDATE_SUCCESS.text,TextCode.UPDATE_SUCCESS.code);
		try {
			//更新医护人员表
			HospitalStaff hospitalStaff = new HospitalStaff();
			BeanUtils.copyProperties(hospitalStaffUpdateDTO,hospitalStaff);
			hospitalStaff.setModifyTime(new Date());
			hospitalStaff.setModifyBy(Oauth2Util.getCurrentUser());
			//
			Long hospitalId = hospitalStaffUpdateDTO.getHospitalId();
			int i = hospitalStaffMapper.updateByPrimaryKey(hospitalStaff);

			//更新用户表
			User user = new User();
			Long userId = hospitalStaffMapper.selectById(hospitalStaffUpdateDTO.getId()).getUserId();
			user.setId(userId);
			user.setRoleId(hospitalStaffUpdateDTO.getRoleId());
			user.setDeptId(hospitalStaffUpdateDTO.getDeptId());
			user.setHospitalId(hospitalId);
			user.setRealName(hospitalStaffUpdateDTO.getRealName());
			user.setPostName(hospitalStaffUpdateDTO.getPostName());
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
	 * @param hospitalStaffUpdateDTO
	 * @return 新增user的主键ID
	 */
	@Override
	public ResponseResult<Long> insertFill(HospitalStaffUpdateDTO hospitalStaffUpdateDTO){
		ResponseResult<Long> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		try {
			//新建空用户 返回主键
			User user = new User();
			userMapper.insertFillReturnId(user);
			//插入医护人员表
			HospitalStaff hospitalStaff = new HospitalStaff();
			hospitalStaff.setCreateBy(Oauth2Util.getCurrentUser());
			hospitalStaff.setOfficeId(hospitalStaffUpdateDTO.getOfficeId());
			hospitalStaff.setCreateTime(hospitalStaffUpdateDTO.getCreateTime());
			hospitalStaff.setCreateBy(Oauth2Util.getCurrentUser());
			hospitalStaff.setUserId(user.getId());
			int i = hospitalStaffMapper.insertFill(hospitalStaff);

			//保存部分user数据
			user.setRoleId(hospitalStaffUpdateDTO.getRoleId());
			user.setHospitalId(hospitalStaffUpdateDTO.getHospitalId());
			user.setDeptId(hospitalStaffUpdateDTO.getDeptId());
			user.setRealName(hospitalStaffUpdateDTO.getRealName());
			user.setPostName(hospitalStaffUpdateDTO.getPostName());
			userMapper.updateByPrimaryKey(user);
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
			data = hospitalStaffMapper.deleteById(id);
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
			data = hospitalStaffMapper.deleteByIds(ids);
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
	public ResponseResult<HospitalStaff> insertFillReturnId(HospitalStaff hospitalStaff){
		ResponseResult<HospitalStaff> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		int i = 0;
		try {
			hospitalStaff.setCreateTime(new Date());
			hospitalStaff.setCreateBy(Oauth2Util.getCurrentUser());
			i = hospitalStaffMapper.insertFillReturnId(hospitalStaff);
			if(i != 1){
				result.setResultText(TextCode.INSERT_FAIL.text);
				result.setResultCode(TextCode.INSERT_FAIL.code);
				return result;
			}
			result.setData(hospitalStaff);
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
	public ResponseResult<Integer> batchSave(List<HospitalStaff> hospitalStaffList){
		ResponseResult<Integer> result = new ResponseResult<>(TextCode.INSERT_SUCCESS.text,TextCode.INSERT_SUCCESS.code);
		int i = 0;
		try {
			if(null != hospitalStaffList && hospitalStaffList.size() > 0){
				hospitalStaffList.forEach(o -> {
					o.setCreateTime(new Date());
					o.setCreateBy(Oauth2Util.getCurrentUser());
				});
			}
			i = hospitalStaffMapper.batchInsert(hospitalStaffList);
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

}
