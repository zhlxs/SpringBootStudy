package com.boot.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.study.entity.SysRoleMenuDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色菜单表 Mapper 接口
 * </p>
 *
 * @author 胡山林
 * @since 2022-05-17
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuDTO> {

}
