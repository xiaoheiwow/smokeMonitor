package me.xhw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @tableName order_record
 * @author xhw
 * @since [0.0.1]
 * @version [0.0.1,2022年08月24日]
 */
@ApiModel(value = "OrderRecord")
public class OrderRecord {
    private static final long serialVersionUID = 1L;

    /**
    *序号
    */
    @ApiModelProperty(value = "序号", required = false)
    private Long id;

    /**
    *订单id
    */
    @ApiModelProperty(value = "订单id", required = false)
    private Long orderId;

    /**
    *推送用户id
    */
    @ApiModelProperty(value = "推送用户id", required = false)
    private Long pusherId;

    /**
    *负责用户id
    */
    @ApiModelProperty(value = "负责用户id", required = false)
    private Long handlerId;

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
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取推送用户id
     *
     * @return pusher_id - 推送用户id
     */
    public Long getPusherId() {
        return pusherId;
    }

    /**
     * 设置推送用户id
     *
     * @param pusherId 推送用户id
     */
    public void setPusherId(Long pusherId) {
        this.pusherId = pusherId;
    }

    /**
     * 获取负责用户id
     *
     * @return handler_id - 负责用户id
     */
    public Long getHandlerId() {
        return handlerId;
    }

    /**
     * 设置负责用户id
     *
     * @param handlerId 负责用户id
     */
    public void setHandlerId(Long handlerId) {
        this.handlerId = handlerId;
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