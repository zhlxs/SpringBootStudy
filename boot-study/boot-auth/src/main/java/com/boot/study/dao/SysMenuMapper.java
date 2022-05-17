package com.boot.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.study.entity.SysMenuDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author 胡山林
 * @since 2022-05-17
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenuDTO> {

}
