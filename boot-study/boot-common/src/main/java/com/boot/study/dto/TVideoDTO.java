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
 * 视频信息表
 * </p>
 *
 * @author 胡山林
 * @since 2022-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_video")
@ApiModel(value="TVideoDTO对象", description="视频信息表")
public class TVideoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "视频名称")
    private String videoName;

    @ApiModelProperty(value = "播放地址")
    private String videoPath;

    @ApiModelProperty(value = "封面地址")
    private String videoCoverPath;

    @ApiModelProperty(value = "视频时长(xx时xx分xx秒)")
    private String videoDuration;

    @ApiModelProperty(value = "所属分类id")
    private Long categoryId;

    @ApiModelProperty(value = "视频描述")
    private String description;

    @ApiModelProperty(value = "转码状态:0未转码,1转码中,2转码完成,3转码失败")
    private Boolean transStatus;

    @ApiModelProperty(value = "文件id")
    private Long attachId;

    @ApiModelProperty(value = "创建人")
    private Long creator;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "删除标识")
    private Boolean delFlag;


}
