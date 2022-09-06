package me.xhw.entity.vo;

import io.swagger.annotations.ApiModelProperty;


/**
 * 角色列表视图对象
 */
public class UserVo {
    /**
     *序号
     */
    @ApiModelProperty(value = "序号", required = false)
    private Long id;

    /**
     *所属医院id
     */
    @ApiModelProperty(value = "所属医院id", required = false)
    private Long hospitalId;


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
     *电话
     */
    @ApiModelProperty(value = "电话", required = false)
    private String phone;

    /**
     *角色名称
     */
    @ApiModelProperty(value = "角色名称", required = false)
    private String roleName;


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

    @ApiModelProperty(value = "token", required = false)
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRealPass() {
        return realPass;
    }

    public void setRealPass(String realPass) {
        this.realPass = realPass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }
}
