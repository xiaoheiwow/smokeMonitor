package me.xhw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @tableName user
 * @author xhw
 * @since [0.0.1]
 * @version [0.0.1,2022年08月16日]
 */
@ApiModel(value = "User", description = "用户表")
public class User {
    private static final long serialVersionUID = 1L;

    /**
    *序号
    */
    @ApiModelProperty(value = "序号", required = false)
    private Long id;

    /**
    *角色id
    */
    @ApiModelProperty(value = "角色id", required = false)
    private Long roleId;

    /**
    *所属医院id
    */
    @ApiModelProperty(value = "所属医院id", required = false)
    private Long hospitalId;

    /**
    *部门id
    */
    @ApiModelProperty(value = "部门id", required = false)
    private Long deptId;

    /**
    *真实姓名
    */
    @ApiModelProperty(value = "真实姓名", required = false)
    private String realName;

    /**
    *账号或ID
    */
    @ApiModelProperty(value = "账号或ID", required = false)
    private String account;

    /**
    *未加密密码
    */
    @ApiModelProperty(value = "未加密密码", required = false)
    private String realPass;

    /**
    *加密密码
    */
    @ApiModelProperty(value = "加密密码", required = false)
    private String password;

    /**
    *电话
    */
    @ApiModelProperty(value = "电话", required = false)
    private String phone;

    /**
    *性别 0男 1女 默认0
    */
    @ApiModelProperty(value = "性别 0男 1女 默认0", required = false)
    private Integer sex;

    /**
    *职务名称
    */
    @ApiModelProperty(value = "职务名称", required = false)
    private String postName;

    /**
    *身份证号码
    */
    @ApiModelProperty(value = "身份证号码", required = false)
    private String identificationNumber;

    /**
    *是否被启用 0否 1已启用 默认0
    */
    @ApiModelProperty(value = "是否被禁用 0否 1已禁用 默认0", required = false)
    private Integer isEnable;

    /**
    *是否被删除 0否 1已删除 默认0 
    */
    @ApiModelProperty(value = "是否被删除 0否 1已删除 默认0 ", required = false)
    private Integer isDelete;

    /**
    *创建时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", required = false)
    private Date createTime;

    /**
    *修改时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间", required = false)
    private Date modifyTime;

    /**
    *创建人
    */
    @ApiModelProperty(value = "创建人", required = false)
    private String createBy;

    /**
    *修改人
    */
    @ApiModelProperty(value = "修改人", required = false)
    private String modifyBy;

    /**
    *备注
    */
    @ApiModelProperty(value = "备注", required = false)
    private String remarks;

    /**
    *是否需要重新登录
    */
    @ApiModelProperty(value = "是否需要重新登录", required = false)
    private Integer needRelogin;

    /**
     * 获取序号
     *
     * @return id - 序号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置序号
     *
     * @param id 序号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取所属医院id
     *
     * @return hospital_id - 所属医院id
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * 设置所属医院id
     *
     * @param hospitalId 所属医院id
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * 获取部门id
     *
     * @return dept_id - 部门id
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置部门id
     *
     * @param deptId 部门id
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取账号或ID
     *
     * @return account - 账号或ID
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号或ID
     *
     * @param account 账号或ID
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取未加密密码
     *
     * @return real_pass - 未加密密码
     */
    public String getRealPass() {
        return realPass;
    }

    /**
     * 设置未加密密码
     *
     * @param realPass 未加密密码
     */
    public void setRealPass(String realPass) {
        this.realPass = realPass;
    }

    /**
     * 获取加密密码
     *
     * @return password - 加密密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置加密密码
     *
     * @param password 加密密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取性别 0男 1女 默认0
     *
     * @return sex - 性别 0男 1女 默认0
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别 0男 1女 默认0
     *
     * @param sex 性别 0男 1女 默认0
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取职务名称
     *
     * @return post_name - 职务名称
     */
    public String getPostName() {
        return postName;
    }

    /**
     * 设置职务名称
     *
     * @param postName 职务名称
     */
    public void setPostName(String postName) {
        this.postName = postName;
    }

    /**
     * 获取身份证号码
     *
     * @return identification_number - 身份证号码
     */
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * 设置身份证号码
     *
     * @param identificationNumber 身份证号码
     */
    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    /**
     * 获取是否被启用 0否 1已启用 默认0
     *
     * @return is_enable - 是否被启用 0否 1已启用 默认0
     */
    public Integer getIsEnable() {
        return isEnable;
    }

    /**
     * 设置是否被启用 0否 1已启用 默认0
     *
     * @param isEnable 是否被启用 0否 1已启用 默认0
     */
    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 获取是否被删除 0否 1已删除 默认0 
     *
     * @return is_delete - 是否被删除 0否 1已删除 默认0 
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否被删除 0否 1已删除 默认0 
     *
     * @param isDelete 是否被删除 0否 1已删除 默认0 
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取修改人
     *
     * @return modify_by - 修改人
     */
    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * 设置修改人
     *
     * @param modifyBy 修改人
     */
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取是否需要重新登录
     *
     * @return need_reLogin - 是否需要重新登录
     */
    public Integer getNeedRelogin() {
        return needRelogin;
    }

    /**
     * 设置是否需要重新登录
     *
     * @param needRelogin 是否需要重新登录
     */
    public void setNeedRelogin(Integer needRelogin) {
        this.needRelogin = needRelogin;
    }
}