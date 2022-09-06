package me.xhw.entity.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 楼宇列表视图对象
 */
public class BuildingVo {
    @ApiModelProperty(value = "", required = false)
    private Long id;

    /**
     *医院id
     */
    @ApiModelProperty(value = "医院id", required = false)
    private Long hospitalId;

    /**
     *楼宇名称
     */
    @ApiModelProperty(value = "楼宇名称", required = false)
    private String buildingName;

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

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}
