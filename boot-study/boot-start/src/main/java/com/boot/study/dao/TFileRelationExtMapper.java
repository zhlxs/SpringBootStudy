package com.boot.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.study.dto.TFileRelationExtDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文件后缀、图标、类型关联表 Mapper 接口
 * </p>
 *
 * @author 胡山林
 * @since 2022-09-03
 */
@Mapper
public interface TFileRelationExtMapper extends BaseMapper<TFileRelationExtDTO> {

}
