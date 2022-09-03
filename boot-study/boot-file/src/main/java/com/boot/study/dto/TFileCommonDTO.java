package com.boot.study.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * 文件公共信息表
 * </p>
 *
 * @author 胡山林
 * @since 2022-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_file_common")
@ApiModel(value="TFileCommonDTO对象", description="文件公共信息表")
public class TFileCommonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;

    @ApiModelProperty(value = "数据类型DIR:目录;IMAGE:图片;VIDEO:视频;AUDIO:音频;DOC:文档;OTHER:其他")
    private String dataType;

    @ApiModelProperty(value = "本地临时目录")
    private String tempPath;

    @ApiModelProperty(value = "文件相对路径")
    private String relativePath;

    @ApiModelProperty(value = "文件访问链接 需要通过nginx配置路由，才能访问")
    private String url;

    @ApiModelProperty(value = "文件md5值")
    private String fileMd5;

    @ApiModelProperty(value = "原始文件名")
    private String submittedFileName;

    @ApiModelProperty(value = "唯一文件名")
    private String filename;

    @ApiModelProperty(value = "文件后缀")
    private String ext;

    @ApiModelProperty(value = "文件大小")
    private Integer size;

    @ApiModelProperty(value = "文件转码地址")
    private String transcodingPath;

    @ApiModelProperty(value = "转码文件大小字节")
    private Integer transcodingSize;

    @ApiModelProperty(value = "文件转码状态：0 尚未转码 1 转码中，2 转码成功 3 转码失败")
    private Boolean transcodingStatus;

    @ApiModelProperty(value = "时长（秒），视频文件才有")
    private Integer duration;

    @ApiModelProperty(value = "缩略图文件地址")
    private String thumbnailPath;

    @ApiModelProperty(value = "缩略图文件大小字节")
    private Integer thumbnailSize;

    @ApiModelProperty(value = "缩略图转码状态：0 尚未转码 1 转码中，2 转码成功 3 转码失败")
    private Boolean thumbnailStatus;

    @ApiModelProperty(value = "是否可以预览")
    private Boolean canPreview;

    @ApiModelProperty(value = "文件上传服务器，0为minio")
    private Boolean storageSource;
}
