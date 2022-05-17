package com.boot.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.study.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author 胡山林
 * @since 2022-05-15
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
