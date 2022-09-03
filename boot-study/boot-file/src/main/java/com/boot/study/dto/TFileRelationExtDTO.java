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
 * 文件后缀、图标、类型关联表
 * </p>
 *
 * @author 胡山林
 * @since 2022-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_file_relation_ext")
@ApiModel(value="TFileRelationExtDTO对象", description="文件后缀、图标、类型关联表")
public class TFileRelationExtDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "后缀名")
    private String ext;

    @ApiModelProperty(value = "文件图标")
    private String icon;

    @ApiModelProperty(value = "文件类型")
    private String dataType;

    @ApiModelProperty(value = "是否是预览类型，1可以预览，0不可以预览，默认可以预览")
    private Boolean canPreview;

    @ApiModelProperty(value = "是否需要扫描,1需要扫描 0不需要扫描  内容监管")
    private Boolean needScan;


}
