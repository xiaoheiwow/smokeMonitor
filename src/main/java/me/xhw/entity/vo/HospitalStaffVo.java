package me.xhw.entity.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 医务人员列表视图对象
 */
public class HospitalStaffVo {


    @ApiModelProperty(value = "", required = false)
    private Long id;


    /**
     *所属医院id
     */
    @ApiModelProperty(value = "所属医院id", required = false)
    private Long hospitalId;


    /**
     *职务名称
     */
    @ApiModelProperty(value = "职务名称", required = false)
    private String postName;

    /**
     *部门名称
     */
    @ApiModelProperty(value = "部门名称", required = false)
    private String deptName;

    /**
     *真实姓名
     */
    @ApiModelProperty(value = "真实姓名", required = false)
    private String realName;

    /**
     *科室名称
     */
    @ApiModelProperty(value = "科室名称", required = false)
    private String officeName;


    /**
     *角色名称
     */
    @ApiModelProperty(value = "角色名称", required = false)
    private String roleName;

    /**
     *创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", required = false)
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
