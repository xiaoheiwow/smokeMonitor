package me.xhw.entity.dto;


import io.swagger.annotations.ApiModelProperty;

public class StaffSimpleQueryDTO {


    /**
     *所属医院id
     */
    @ApiModelProperty(value = "所属医院id", required = false)
    private Long hospitalId;

    /**
     *部门id
     */
    @ApiModelProperty(value = "部门id", required = false)
    private Long deptId;

    /**
     *角色id
     */
    @ApiModelProperty(value = "角色id", required = false)
    private Long roleId;

    /**
     *职务名称
     */
    @ApiModelProperty(value = "职务名称", required = false)
    private String postName;

    /**
     *真实姓名
     */
    @ApiModelProperty(value = "真实姓名", required = false)
    private String realName;

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
