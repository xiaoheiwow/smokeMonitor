package me.xhw.entity.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用于分配工单给指定人员
 */
public class UserSelectVo {
    @ApiModelProperty(value = "用户id", required = false)
    private Long id;

    /**
     *用户名称
     */
    @ApiModelProperty(value = "用户名称", required = false)
    private String realName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
