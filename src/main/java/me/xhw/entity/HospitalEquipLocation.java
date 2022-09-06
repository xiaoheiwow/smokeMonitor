package me.xhw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @tableName hospital_equip_location
 * @author xhw
 * @since [0.0.1]
 * @version [0.0.1,2022年08月18日]
 */
@ApiModel(value = "HospitalEquipLocation", description = "设备所在点位表")
public class HospitalEquipLocation {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "", required = false)
    private Long id;

    /**
    *所属医院id
    */
    @ApiModelProperty(value = "所属医院id", required = false)
    private Long hospitalId;

    /**
    *点位名称
    */
    @ApiModelProperty(value = "点位名称", required = false)
    private String locationName;

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
    *医院设备点位描述
    */
    @ApiModelProperty(value = "医院设备点位描述", required = false)
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
     * 获取点位名称
     *
     * @return location_name - 点位名称
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * 设置点位名称
     *
     * @param locationName 点位名称
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
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
     * 获取医院设备点位描述
     *
     * @return remarks - 医院设备点位描述
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置医院设备点位描述
     *
     * @param remarks 医院设备点位描述
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}