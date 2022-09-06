package me.xhw.entity.vo;

import io.swagger.annotations.ApiModelProperty;

public class OfficeSelectVo {

    @ApiModelProperty(value = "", required = false)
    private Long id;

    /**
     *科室名称
     */
    @ApiModelProperty(value = "科室名称", required = false)
    private String officeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }


}
