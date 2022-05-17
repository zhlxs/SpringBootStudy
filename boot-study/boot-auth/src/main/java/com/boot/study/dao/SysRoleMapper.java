package com.boot.study.dao;

import com.boot.study.entity.SysRoleDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统角色表 Mapper 接口
 * </p>
 *
 * @author 胡山林
 * @since 2022-05-17
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRoleDTO> {

}
