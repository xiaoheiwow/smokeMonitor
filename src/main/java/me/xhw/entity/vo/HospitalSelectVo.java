package me.xhw.entity.vo;

import io.swagger.annotations.ApiModelProperty;


/**
 * 用于选择医院
 */
public class HospitalSelectVo {
    @ApiModelProperty(value = "", required = false)
    private Long id;

    /**
     *医院名称
     */
    @ApiModelProperty(value = "医院名称", required = false)
    private String hospitalName;

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
}
