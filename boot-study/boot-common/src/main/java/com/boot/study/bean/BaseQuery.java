package com.boot.study.bean;

import io.swagger.annotations.ApiModelProperty;

/**
 * 基础查询参数封装
 */
public class BaseQuery {

    @ApiModelProperty(value = "页数")
    private Integer current;

    @ApiModelProperty(value = "每页条数")
    private Integer size;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
