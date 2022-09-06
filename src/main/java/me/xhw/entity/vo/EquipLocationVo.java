package me.xhw.entity.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 设备点位列表视图对象
 */
public class EquipLocationVo {
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

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
