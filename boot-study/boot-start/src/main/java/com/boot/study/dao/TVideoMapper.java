package com.boot.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.study.dto.TVideoDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 视频信息表 Mapper 接口
 * </p>
 *
 * @author 胡山林
 * @since 2022-09-03
 */
@Mapper
public interface TVideoMapper extends BaseMapper<TVideoDTO> {

}
