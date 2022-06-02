package com.boot.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.study.bean.PageQueryCondition;
import com.boot.study.bean.PageQueryResult;
import com.boot.study.bean.Result;
import com.boot.study.entity.SysRoleDTO;
import com.boot.study.vo.SysRoleAddVO;
import com.boot.study.vo.SysRoleUpdateVO;
import com.boot.study.vo.SysRoleVO;

/**
 * <p>
 * 系统角色表 服务类
 * </p>
 *
 * @author 胡山林
 * @since 2022-05-17
 */
public interface SysRoleService extends IService<SysRoleDTO> {

    /**
     * 角色分页查询
     *
     * @param pageQueryCondition
     * @return
     */
    PageQueryResult<SysRoleDTO> pager(PageQueryCondition<SysRoleVO> pageQueryCondition);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    SysRoleDTO findById(Long id);

    /**
     * 修改
     *
     * @param roleUpdateVO
     * @return
     */
    Result updateRole(SysRoleUpdateVO roleUpdateVO);

    /**
     * 新增
     *
     * @param roleAddVO
     * @return
     */
    Result addRole(SysRoleAddVO roleAddVO);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Result delRole(Long id);
}
