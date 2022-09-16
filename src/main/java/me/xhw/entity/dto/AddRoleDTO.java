package me.xhw.entity.dto;


import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;

/**
 * 添加角色传输对象
 * @author xiaoheiwow
 */
public class AddRoleDTO {
    /**
     *角色名称
     */
    @ApiModelProperty(value = "角色名称", required = false)
    private String roleName;

    /**
     *权限数组
     */
    @ApiModelProperty(value = "权限组", required = false)
    private  Long[] permissions;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long[] getPermissions() {
        return permissions;
    }

    public void setPermissions(Long[] permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "AddRoleDTO{" +
                "roleName='" + roleName + '\'' +
                ", permissions=" + Arrays.toString(permissions) +
                '}';
    }
}
