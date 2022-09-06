package me.xhw.entity.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 工单列表视图对象
 */
public class OrderVo {

    @ApiModelProperty(value = "", required = false)
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getPusherName() {
        return pusherName;
    }

    public void setPusherName(String pusherName) {
        this.pusherName = pusherName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getOrderProgress() {
        return orderProgress;
    }

    public void setOrderProgress(String orderProgress) {
        this.orderProgress = orderProgress;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Integer getSituation() {
        return situation;
    }

    public void setSituation(Integer situation) {
        this.situation = situation;
    }

    public String getHandlerPhone() {
        return handlerPhone;
    }

    public void setHandlerPhone(String handlerPhone) {
        this.handlerPhone = handlerPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
