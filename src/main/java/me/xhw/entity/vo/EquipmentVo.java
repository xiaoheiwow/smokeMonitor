package me.xhw.entity.vo;


import io.swagger.annotations.ApiModelProperty;

/**
 * 设备点位列表视图对象
 */
public class EquipmentVo {
    @ApiModelProperty(value = "", required = false)
    private Long id;

    /**
     * 所属医院
     */
    @ApiModelProperty(value = "所属医院", required = false)
    private String hospitalName;

    /**
     * 设备名称
     */
    @ApiModelProperty(value = "设备名称/摄像机编号", required = false)
    private String equipName;

     /**
     *摄像机定位
     */
    @ApiModelProperty(value = "摄像机定位", required = false)
    private String position;

    /**
     * 所在楼宇
     */
    @ApiModelProperty(value = "所在楼宇", required = false)
    private String building;

    /**
     * 设备点位
     */
    @ApiModelProperty(value = "设备点位", required = false)
    private String equipLocation;

    /**
     * ip地址
     */
    @ApiModelProperty(value = "ip地址", required = false)
    private String ipLocation;


    /**
     * 使用者
     */
    @ApiModelProperty(value = "使用者/账号", required = false)
    private String userName;

    /**
     * 设备密码
     */
    @ApiModelProperty(value = "设备密码", required = false)
    private String password;

    /**
     * 设备状态 默认0-离线 1-在线
     */
    @ApiModelProperty(value = "设备状态 默认0-离线 1-在线", required = false)
    private Integer equipStatus;

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

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String cameraPosition) {
        this.position = cameraPosition;
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

    public String getIpLocation() {
        return ipLocation;
    }

    public void setIpLocation(String ipLocation) {
        this.ipLocation = ipLocation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEquipStatus() {
        return equipStatus;
    }

    public void setEquipStatus(Integer equipStatus) {
        this.equipStatus = equipStatus;
    }
}
