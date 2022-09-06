package me.xhw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @tableName equipment
 * @author xhw
 * @since [0.0.1]
 * @version [0.0.1,2022年08月16日]
 */
@ApiModel(value = "Equipment", description = "设备表")
public class Equipment {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "", required = false)
    private Long id;

    /**
    *所属医院id
    */
    @ApiModelProperty(value = "所属医院id", required = false)
    private Long hospitalId;

    /**
    *设备名称
    */
    @ApiModelProperty(value = "设备名称", required = false)
    private String equipName;

    /**
    *所在楼宇
    */
    @ApiModelProperty(value = "所在楼宇", required = false)
    private String building;

    /**
    *设备点位
    */
    @ApiModelProperty(value = "设备点位", required = false)
    private String equipLocation;

    /**
    *ip地址
    */
    @ApiModelProperty(value = "ip地址", required = false)
    private String ipLocation;

    /**
    *设备状态 默认0-离线 1-在线
    */
    @ApiModelProperty(value = "设备状态 默认0-离线 1-在线", required = false)
    private Integer equipStatus;

    /**
    *使用者
    */
    @ApiModelProperty(value = "使用者", required = false)
    private String userName;

    /**
    *设备密码
    */
    @ApiModelProperty(value = "设备密码", required = false)
    private String password;

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
    *设备描述
    */
    @ApiModelProperty(value = "设备描述", required = false)
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
     * 获取设备名称
     *
     * @return equip_name - 设备名称
     */
    public String getEquipName() {
        return equipName;
    }

    /**
     * 设置设备名称
     *
     * @param equipName 设备名称
     */
    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    /**
     * 获取所在楼宇
     *
     * @return building - 所在楼宇
     */
    public String getBuilding() {
        return building;
    }

    /**
     * 设置所在楼宇
     *
     * @param building 所在楼宇
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /**
     * 获取设备点位
     *
     * @return equip_location - 设备点位
     */
    public String getEquipLocation() {
        return equipLocation;
    }

    /**
     * 设置设备点位
     *
     * @param equipLocation 设备点位
     */
    public void setEquipLocation(String equipLocation) {
        this.equipLocation = equipLocation;
    }

    /**
     * 获取ip地址
     *
     * @return ip_location - ip地址
     */
    public String getIpLocation() {
        return ipLocation;
    }

    /**
     * 设置ip地址
     *
     * @param ipLocation ip地址
     */
    public void setIpLocation(String ipLocation) {
        this.ipLocation = ipLocation;
    }

    /**
     * 获取设备状态 默认0-离线 1-在线
     *
     * @return equip_status - 设备状态 默认0-离线 1-在线
     */
    public Integer getEquipStatus() {
        return equipStatus;
    }

    /**
     * 设置设备状态 默认0-离线 1-在线
     *
     * @param equipStatus 设备状态 默认0-离线 1-在线
     */
    public void setEquipStatus(Integer equipStatus) {
        this.equipStatus = equipStatus;
    }

    /**
     * 获取使用者
     *
     * @return user_name - 使用者
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置使用者
     *
     * @param userName 使用者
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取设备密码
     *
     * @return password - 设备密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置设备密码
     *
     * @param password 设备密码
     */
    public void setPassword(String password) {
        this.password = password;
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
     * 获取设备描述
     *
     * @return remarks - 设备描述
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置设备描述
     *
     * @param remarks 设备描述
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}