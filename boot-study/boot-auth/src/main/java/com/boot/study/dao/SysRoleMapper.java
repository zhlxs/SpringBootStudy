package com.boot.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.study.entity.SysRoleDTO;
import com.boot.study.vo.SysRoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 分页查询
     *
     * @param page
     * @param model
     * @return
     */
    IPage<SysRoleDTO> pager(Page<SysRoleVO> page, @Param("condition") SysRoleVO model);
}
