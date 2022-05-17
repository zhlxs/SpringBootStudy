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
import java.util.Date;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author 胡山林
 * @since 2022-05-17
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@TableName("sys_menu")
@ApiModel(value = "SysMenuDTO对象", description = "菜单表")
public class SysMenuDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "菜单名")
    private String menuName;

    @ApiModelProperty(value = "路由地址")
    private String path;

    @ApiModelProperty(value = "组件路径")
    private String component;

    @ApiModelProperty(value = "显示状态（0显示，1隐藏）")
    private Boolean visible;

    @ApiModelProperty(value = "菜单状态（0正常，1停用）")
    private Boolean status;

    @ApiModelProperty(value = "权限标识")
    private String perms;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "创建人")
    private Long creator;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除：0未删除，1已删除")
    private Boolean delFlag;

    @ApiModelProperty(value = "备注")
    private String remark;


}
