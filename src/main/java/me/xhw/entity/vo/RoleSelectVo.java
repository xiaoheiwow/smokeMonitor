package me.xhw.entity.vo;

import io.swagger.annotations.ApiModelProperty;


/**
 * 用于获取所有角色
 */
public class RoleSelectVo {
    @ApiModelProperty(value = "", required = false)
    private Long id;

    /**
     *医院名称
     */
    @ApiModelProperty(value = "角色名称", required = false)
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
