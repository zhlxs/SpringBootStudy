package com.boot.study.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

/**
 * 角色新增对象
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel(value = "角色新增对象", description = "角色新增参数")
public class SysRoleAddVO {

    @ApiModelProperty(value = "角色名称")
    @NotEmpty(message = "角色名称不能为空")
    private String roleName;

    @ApiModelProperty(value = "角色标识")
    @NotEmpty(message = "角色标识不能为空")
    private String roleKey;
}
