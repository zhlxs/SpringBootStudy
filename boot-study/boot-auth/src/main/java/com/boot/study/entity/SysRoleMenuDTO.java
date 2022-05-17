package com.boot.study.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 角色菜单表
 * </p>
 *
 * @author 胡山林
 * @since 2022-05-17
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@TableName("sys_role_menu")
@ApiModel(value = "SysRoleMenuDTO对象", description = "角色菜单表")
public class SysRoleMenuDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    @TableId(value = "role_id", type = IdType.ID_WORKER)
    private Integer roleId;

    @ApiModelProperty(value = "菜单id")
    private Integer menuId;


}
