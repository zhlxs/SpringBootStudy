package com.boot.study.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 角色更新对象
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel(value = "角色更新对象", description = "角色更新参数")
public class SysRoleUpdateVO {


    @ApiModelProperty(value = "角色id")
    @NotNull(message = "角色id不能为空")
    private Long id;

    @ApiModelProperty(value = "角色名称")
    @NotEmpty(message = "角色名不能为空")
    private String roleName;
}
