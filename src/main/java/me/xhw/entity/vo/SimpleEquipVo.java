package me.xhw.entity.vo;

import io.swagger.annotations.ApiModelProperty;


/**
 * 医院列表下简单设备视图对象
 */
public class SimpleEquipVo {

    @ApiModelProperty(value = "", required = false)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getEquipLocation() {
        return equipLocation;
    }

    public void setEquipLocation(String equipLocation) {
        this.equipLocation = equipLocation;
    }
}
