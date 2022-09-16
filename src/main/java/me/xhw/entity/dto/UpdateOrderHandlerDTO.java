package me.xhw.entity.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author xiaoheiwow
 */
public class UpdateOrderHandlerDTO {


    @ApiModelProperty(value = "", required = false)
    private Long id;

    /**
     *处理人/负责人  ID
     */
    @ApiModelProperty(value = "处理人ID", required = false)
    private Long userId;

    /**
     *处理人/负责人
     */
    @ApiModelProperty(value = "处理人/负责人", required = false)
    private String handlerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    @Override
    public String toString() {
        return "UpdateOrderHandlerDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", handlerName='" + handlerName + '\'' +
                '}';
    }
}
