package com.boot.study.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文件业务表
 * </p>
 *
 * @author 胡山林
 * @since 2022-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_file")
@ApiModel(value="TFileDTO对象", description="文件业务表")
public class TFileDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文件唯一主键id")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "业务主键id")
    private Long bizId;

    @ApiModelProperty(value = "文件业务类型")
    private String bizType;

    @ApiModelProperty(value = "文件原始名")
    private String submittedFileName;

    @ApiModelProperty(value = "对应的文件公共信息id")
    private Long fileCommonId;

    @ApiModelProperty(value = "文件唯一标识")
    private String uuid;

    @ApiModelProperty(value = "创建人")
    private Long creator;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "删除标识")
    private Boolean delFlag;


}
