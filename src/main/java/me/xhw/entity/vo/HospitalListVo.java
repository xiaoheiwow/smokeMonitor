package me.xhw.entity.vo;

import io.swagger.annotations.ApiModelProperty;


/**
 * 医院列表视图对象
 */
public class HospitalListVo {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalLevel() {
        return hospitalLevel;
    }

    public void setHospitalLevel(String hospitalLevel) {
        this.hospitalLevel = hospitalLevel;
    }

    public String getHospitalType() {
        return hospitalType;
    }

    public void setHospitalType(String hospitalType) {
        this.hospitalType = hospitalType;
    }

    public String getHospitalRegion() {
        return hospitalRegion;
    }

    public void setHospitalRegion(String hospitalRegion) {
        this.hospitalRegion = hospitalRegion;
    }

    public String getHospitalLocation() {
        return hospitalLocation;
    }

    public void setHospitalLocation(String hospitalLocation) {
        this.hospitalLocation = hospitalLocation;
    }

    public Integer getEquipmentQuantity() {
        return equipmentQuantity;
    }

    public void setEquipmentQuantity(Integer equipmentQuantity) {
        this.equipmentQuantity = equipmentQuantity;
    }
}
