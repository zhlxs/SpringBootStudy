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
 * 文件转码任务表(定时任务)
 * </p>
 *
 * @author 胡山林
 * @since 2022-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_file_transtask")
@ApiModel(value="TFileTranstaskDTO对象", description="文件转码任务表(定时任务)")
public class TFileTranstaskDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "文件id")
    private Long fileCommonId;

    @ApiModelProperty(value = "转码类型")
    private Boolean transType;

    @ApiModelProperty(value = "0 尚未转码 1 转码中，2 转码成功 3 转码失败")
    private Boolean transStatus;


}
