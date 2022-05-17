package com.boot.study.dao;

import com.boot.study.entity.SysUserRoleDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户角色信息表 Mapper 接口
 * </p>
 *
 * @author 胡山林
 * @since 2022-05-17
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleDTO> {

}
