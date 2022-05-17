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
 * 用户角色信息表
 * </p>
 *
 * @author 胡山林
 * @since 2022-05-17
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@TableName("sys_user_role")
@ApiModel(value = "SysUserRoleDTO对象", description = "用户角色信息表")
public class SysUserRoleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "user_id", type = IdType.ID_WORKER)
    private Integer userId;

    @ApiModelProperty(value = "角色id")
    private Integer roleId;


}
