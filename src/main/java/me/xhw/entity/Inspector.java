package me.xhw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @tableName inspector
 * @author xhw
 * @since [0.0.1]
 * @version [0.0.1,2022年08月22日]
 */
@ApiModel(value = "Inspector", description = "巡查人员关系表")
public class Inspector {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "", required = false)
    private Long id;

    /**
    *用户id
    */
    @ApiModelProperty(value = "用户id", required = false)
    private Long userId;

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
    *角色描述
    */
    @ApiModelProperty(value = "角色描述", required = false)
    private String remarks;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取巡查范围
     *
     * @return scope - 巡查范围
     */
    public String getScope() {
        return scope;
    }

    /**
     * 设置巡查范围
     *
     * @param scope 巡查范围
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * 获取花费时间
     *
     * @return cost_time - 花费时间
     */
    public Integer getCostTime() {
        return costTime;
    }

    /**
     * 设置花费时间
     *
     * @param costTime 花费时间
     */
    public void setCostTime(Integer costTime) {
        this.costTime = costTime;
    }


    /**
     * 获取默认 0-未被禁止 1-已被禁止
     *
     * @return is_banned - 默认 0-未被禁止 1-已被禁止
     */
    public Integer getIsBanned() {
        return isBanned;
    }

    /**
     * 设置默认 0-未被禁止 1-已被禁止
     *
     * @param isBanned 默认 0-未被禁止 1-已被禁止
     */
    public void setIsBanned(Integer isBanned) {
        this.isBanned = isBanned;
    }

    /**
     * 获取最后登录时间
     *
     * @return last_time - 最后登录时间
     */
    public Date getLastTime() {
        return lastTime;
    }


    /**
     * 设置最后登录时间
     *
     * @param lastTime 最后登录时间
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * 获取最后登录ip
     *
     * @return ip_location - 最后登录ip
     */
    public String getIpLocation() {
        return ipLocation;
    }

    /**
     * 设置最后登录ip
     *
     * @param ipLocation 最后登录ip
     */
    public void setIpLocation(String ipLocation) {
        this.ipLocation = ipLocation;
    }

    /**
     * 获取登录次数
     *
     * @return login_times - 登录次数
     */
    public String getLoginTimes() {
        return loginTimes;
    }

    /**
     * 设置登录次数
     *
     * @param loginTimes 登录次数
     */
    public void setLoginTimes(String loginTimes) {
        this.loginTimes = loginTimes;
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
     * 获取角色描述
     *
     * @return remarks - 角色描述
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置角色描述
     *
     * @param remarks 角色描述
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}