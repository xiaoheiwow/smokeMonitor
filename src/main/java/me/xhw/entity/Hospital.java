package me.xhw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @tableName hospital
 * @author xhw
 * @since [0.0.1]
 * @version [0.0.1,2022年08月16日]
 */
@ApiModel(value = "Hospital", description = "医院列表")
public class Hospital {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "", required = false)
    private Long id;

    /**
    *医院名称
    */
    @ApiModelProperty(value = "医院名称", required = false)
    private String hospitalName;

    /**
    *医院等级
    */
    @ApiModelProperty(value = "医院等级", required = false)
    private String hospitalLevel;

    /**
    *医院类别
    */
    @ApiModelProperty(value = "医院类别", required = false)
    private String hospitalType;

    /**
    *医院所属区域
    */
    @ApiModelProperty(value = "医院所属区域", required = false)
    private String hospitalRegion;

    /**
    *医院所在位置
    */
    @ApiModelProperty(value = "医院所在位置", required = false)
    private String hospitalLocation;

    /**
    *设备数量
    */
    @ApiModelProperty(value = "设备数量", required = false)
    private Integer equipmentQuantity;

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
    *医院描述
    */
    @ApiModelProperty(value = "医院描述", required = false)
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
     * 获取医院名称
     *
     * @return hospital_name - 医院名称
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * 设置医院名称
     *
     * @param hospitalName 医院名称
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    /**
     * 获取医院等级
     *
     * @return hospital_level - 医院等级
     */
    public String getHospitalLevel() {
        return hospitalLevel;
    }

    /**
     * 设置医院等级
     *
     * @param hospitalLevel 医院等级
     */
    public void setHospitalLevel(String hospitalLevel) {
        this.hospitalLevel = hospitalLevel;
    }

    /**
     * 获取医院类别
     *
     * @return hospital_type - 医院类别
     */
    public String getHospitalType() {
        return hospitalType;
    }

    /**
     * 设置医院类别
     *
     * @param hospitalType 医院类别
     */
    public void setHospitalType(String hospitalType) {
        this.hospitalType = hospitalType;
    }

    /**
     * 获取医院所属区域
     *
     * @return hospital_region - 医院所属区域
     */
    public String getHospitalRegion() {
        return hospitalRegion;
    }

    /**
     * 设置医院所属区域
     *
     * @param hospitalRegion 医院所属区域
     */
    public void setHospitalRegion(String hospitalRegion) {
        this.hospitalRegion = hospitalRegion;
    }

    /**
     * 获取医院所在位置
     *
     * @return hospital_location - 医院所在位置
     */
    public String getHospitalLocation() {
        return hospitalLocation;
    }

    /**
     * 设置医院所在位置
     *
     * @param hospitalLocation 医院所在位置
     */
    public void setHospitalLocation(String hospitalLocation) {
        this.hospitalLocation = hospitalLocation;
    }

    /**
     * 获取设备数量
     *
     * @return equipment_quantity - 设备数量
     */
    public Integer getEquipmentQuantity() {
        return equipmentQuantity;
    }

    /**
     * 设置设备数量
     *
     * @param equipmentQuantity 设备数量
     */
    public void setEquipmentQuantity(Integer equipmentQuantity) {
        this.equipmentQuantity = equipmentQuantity;
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
     * 获取医院描述
     *
     * @return remarks - 医院描述
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置医院描述
     *
     * @param remarks 医院描述
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}