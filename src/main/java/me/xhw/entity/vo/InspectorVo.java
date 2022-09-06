package me.xhw.entity.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 巡查人员列表视图对象
 */
public class InspectorVo {

    @ApiModelProperty(value = "", required = false)
    private Long id;

    /**
     *巡查范围
     */
    @ApiModelProperty(value = "巡查范围", required = false)
    private String scope;

    /**
     *花费时间
     */
    @ApiModelProperty(value = "花费时间", required = false)
    private Integer costTime;

    /**
     *默认 0-未被禁止 1-已被禁止
     */
    @ApiModelProperty(value = "默认 0-未被禁止 1-已被禁止", required = false)
    private Integer isBanned;

    /**
     *最后登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后登录时间", required = false)
    private Date lastTime;

    /**
     *拉黑时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "拉黑时间", required = false)
    private Date bannedTime;

    /**
     *最后登录ip
     */
    @ApiModelProperty(value = "最后登录ip", required = false)
    private String ipLocation;

    /**
     *登录次数
     */
    @ApiModelProperty(value = "登录次数", required = false)
    private String loginTimes;

    /**
     *职务名称
     */
    @ApiModelProperty(value = "职务名称", required = false)
    private String postName;

    /**
     *电话
     */
    @ApiModelProperty(value = "电话", required = false)
    private String phone;


    /**
     *真实姓名
     */
    @ApiModelProperty(value = "真实姓名", required = false)
    private String realName;

    /**
     *所属医院id
     */
    @ApiModelProperty(value = "所属医院id", required = false)
    private Long hospitalId;

    /**
     *账号或ID
     */
    @ApiModelProperty(value = "账号或ID", required = false)
    private String account;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getCostTime() {
        return costTime;
    }

    public void setCostTime(Integer costTime) {
        this.costTime = costTime;
    }

    public Integer getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(Integer isBanned) {
        this.isBanned = isBanned;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getIpLocation() {
        return ipLocation;
    }

    public void setIpLocation(String ipLocation) {
        this.ipLocation = ipLocation;
    }

    public String getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(String loginTimes) {
        this.loginTimes = loginTimes;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Date getBannedTime() {
        return bannedTime;
    }

    public void setBannedTime(Date bannedTime) {
        this.bannedTime = bannedTime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
