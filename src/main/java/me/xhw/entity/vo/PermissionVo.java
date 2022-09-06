package me.xhw.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.List;


public class PermissionVo implements Serializable {


    @ApiModelProperty(value = "权限id")
    private Long id;

    @ApiModelProperty(value = "菜单或权限名称")
    private String permissionName;

    @ApiModelProperty(value = "子菜单")
    private List<PermissionVo> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }


    public List<PermissionVo> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionVo> children) {
        this.children = children;
    }
}
