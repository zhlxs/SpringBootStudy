package com.boot.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.study.dto.TFileTranstaskDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文件转码任务表(定时任务) Mapper 接口
 * </p>
 *
 * @author 胡山林
 * @since 2022-09-03
 */
@Mapper
public interface TFileTranstaskMapper extends BaseMapper<TFileTranstaskDTO> {

}
