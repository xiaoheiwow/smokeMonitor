package me.xhw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @tableName order
 * @author xhw
 * @since [0.0.1]
 * @version [0.0.1,2022年08月23日]
 */
@ApiModel(value = "Order")
public class Order {
    private static final long serialVersionUID = 1L;

    /**
    *序号
    */
    @ApiModelProperty(value = "序号", required = false)
    private Long id;

    /**
    *医院id
    */
    @ApiModelProperty(value = "医院id", required = false)
    private Long hospitalId;

    /**
    *处理人/负责人
    */
    @ApiModelProperty(value = "处理人/负责人", required = false)
    private String handlerName;

    /**
    *提交人/推送者
    */
    @ApiModelProperty(value = "提交人/推送者", required = false)
    private String pusherName;

    /**
    *工单编号
    */
    @ApiModelProperty(value = "工单编号", required = false)
    private String orderNumber;

    /**
    *报警类型
    */
    @ApiModelProperty(value = "报警类型", required = false)
    private String alarmType;

    /**
    *工单进度
    */
    @ApiModelProperty(value = "工单进度", required = false)
    private String orderProgress;

    /**
    *优先度
    */
    @ApiModelProperty(value = "优先度", required = false)
    private String priority;

    /**
    *默认0-待处理 1-处理中 2-已处理
    */
    @ApiModelProperty(value = "默认0-待处理 1-处理中 2-已处理", required = false)
    private Integer situation;

    /**
    *负责人电话
    */
    @ApiModelProperty(value = "负责人电话", required = false)
    private String handlerPhone;

    /**
    *地址
    */
    @ApiModelProperty(value = "地址", required = false)
    private String address;

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
     * 获取医院id
     *
     * @return hospital_id - 医院id
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * 设置医院id
     *
     * @param hospitalId 医院id
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * 获取处理人/负责人
     *
     * @return handler_name - 处理人/负责人
     */
    public String getHandlerName() {
        return handlerName;
    }

    /**
     * 设置处理人/负责人
     *
     * @param handlerName 处理人/负责人
     */
    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    /**
     * 获取提交人/推送者
     *
     * @return pusher_name - 提交人/推送者
     */
    public String getPusherName() {
        return pusherName;
    }

    /**
     * 设置提交人/推送者
     *
     * @param pusherName 提交人/推送者
     */
    public void setPusherName(String pusherName) {
        this.pusherName = pusherName;
    }

    /**
     * 获取工单编号
     *
     * @return order_number - 工单编号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置工单编号
     *
     * @param orderNumber 工单编号
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取报警类型
     *
     * @return alarmType - 报警类型
     */
    public String getAlarmType() {
        return alarmType;
    }

    /**
     * 设置报警类型
     *
     * @param alarmtype 报警类型
     */
    public void setAlarmType(String alarmtype) {
        this.alarmType = alarmtype;
    }

    /**
     * 获取工单进度
     *
     * @return order_progress - 工单进度
     */
    public String getOrderProgress() {
        return orderProgress;
    }

    /**
     * 设置工单进度
     *
     * @param orderProgress 工单进度
     */
    public void setOrderProgress(String orderProgress) {
        this.orderProgress = orderProgress;
    }

    /**
     * 获取优先度
     *
     * @return priority - 优先度
     */
    public String getPriority() {
        return priority;
    }

    /**
     * 设置优先度
     *
     * @param priority 优先度
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * 获取默认0-待处理 1-处理中 2-已处理
     *
     * @return situation - 默认0-待处理 1-处理中 2-已处理
     */
    public Integer getSituation() {
        return situation;
    }

    /**
     * 设置默认0-待处理 1-处理中 2-已处理
     *
     * @param situation 默认0-待处理 1-处理中 2-已处理
     */
    public void setSituation(Integer situation) {
        this.situation = situation;
    }

    /**
     * 获取负责人电话
     *
     * @return handler_phone - 负责人电话
     */
    public String getHandlerPhone() {
        return handlerPhone;
    }

    /**
     * 设置负责人电话
     *
     * @param handlerPhone 负责人电话
     */
    public void setHandlerPhone(String handlerPhone) {
        this.handlerPhone = handlerPhone;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
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
}