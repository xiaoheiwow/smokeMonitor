package me.xhw.entity.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用于选择部门
 */
public class DepartmentSelectVo {

    @ApiModelProperty(value = "", required = false)
    private Long id;

    /**
     *部门名称
     */
    @ApiModelProperty(value = "部门名称", required = false)
    private String deptName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
