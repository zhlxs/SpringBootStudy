package com.boot.study.vo;

import com.boot.study.bean.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 角色查询对象
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel(value = "角色查询对象", description = "角色查询参数")
public class SysRoleVO extends BaseQuery {

    @ApiModelProperty(value = "角色名称")
    private String roleName;
}
