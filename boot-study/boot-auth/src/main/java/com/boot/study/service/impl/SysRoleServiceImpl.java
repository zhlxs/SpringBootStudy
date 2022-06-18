package com.boot.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.study.bean.*;
import com.boot.study.constant.SystemConstants;
import com.boot.study.dao.SysRoleMapper;
import com.boot.study.entity.SysRoleDTO;
import com.boot.study.exception.BaseExceptionCode;
import com.boot.study.exception.ExceptionCode;
import com.boot.study.service.SysRoleService;
import com.boot.study.vo.SysRoleAddVO;
import com.boot.study.vo.SysRoleUpdateVO;
import com.boot.study.vo.SysRoleVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author 胡山林
 * @since 2022-05-17
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleDTO> implements SysRoleService {

    @Autowired
    private GeneralConvertor convertor;
    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public PageQueryResult<SysRoleDTO> pager(PageQueryCondition<SysRoleVO> condition) {
        Page<SysRoleVO> page = PageUtil.transPageQueryCondition2MybatisPlusPage(condition, convertor);
        IPage<SysRoleDTO> result = roleMapper.pager(page, condition.getModel());
        return PageUtil.transMybatisPlusPage2PageQueryResult(result);
    }

    @Override
    public SysRoleDTO findById(Long id) {
        //逻辑删除的数据不再返回
        return roleMapper.selectOne(new QueryWrapper<SysRoleDTO>().eq("id", id)
                .eq("del_flag", SystemConstants.NO_DEL_FLAG_VALUE));
    }

    @Override
    public Result updateRole(SysRoleUpdateVO roleUpdateVO) {
        Assert.notNull(roleUpdateVO.getId(), "角色ID不能为空");
        SysRoleDTO roleDTO = roleMapper.selectOne(new QueryWrapper<SysRoleDTO>().eq("id", roleUpdateVO.getId())
                .eq("del_flag", SystemConstants.NO_DEL_FLAG_VALUE));
        if (roleDTO == null) {
            return Result.fail(ExceptionCode.INVALID_DATA.build("学生不存在"));
        }
        BaseExceptionCode baseExceptionCode = checkRoleValid(convertor.convertor(roleUpdateVO, SysRoleDTO.class));
        if (baseExceptionCode != null) {
            return Result.fail(baseExceptionCode);
        }
        SysRoleDTO update = this.convertor.convertor(roleUpdateVO, SysRoleDTO.class);
        update.setUpdateTime(new Date());
        // roleMapper.updateById(update);
        roleMapper.update(null, Wrappers.<SysRoleDTO>lambdaUpdate().set(SysRoleDTO::getRoleName,roleUpdateVO.getRoleName()).eq(SysRoleDTO::getId,roleUpdateVO.getId()));
        return Result.renderSuccess(SystemConstants.UPDATE_SUCCESS_MSG);
    }

    /**
     * 校验角色名称
     *
     * @param newRole
     * @return
     */
    private BaseExceptionCode checkRoleValid(SysRoleDTO newRole) {
        if (StringUtils.isNotEmpty(newRole.getRoleName())) {
            SysRoleDTO roleDTO = roleMapper.selectOne(new QueryWrapper<SysRoleDTO>()
                    .eq("role_name", newRole.getRoleName())
                    .eq("del_flag", SystemConstants.NO_DEL_FLAG_VALUE));
            if (roleDTO != null) {
                if (roleDTO.getId() == null || (roleDTO.getId() != null && !roleDTO.getId().equals(newRole.getId()))) {
                    return ExceptionCode.INVALID_DATA.build("角色名称[%s]已经被占用", newRole.getRoleName());
                }
            }
        }

        if (StringUtils.isNotEmpty(newRole.getRoleKey())) {
            SysRoleDTO roleDTO = roleMapper.selectOne(new QueryWrapper<SysRoleDTO>()
                    .eq("role_key", newRole.getRoleKey())
                    .eq("del_flag", SystemConstants.NO_DEL_FLAG_VALUE));
            if (roleDTO != null) {
                if (roleDTO.getId() == null || (roleDTO.getId() != null && !roleDTO.getId().equals(newRole.getId()))) {
                    return ExceptionCode.INVALID_DATA.build("角色标识[%s]已经存在", newRole.getRoleKey());
                }
            }
        }
        return null;
    }

    @Override
    public Result addRole(SysRoleAddVO roleAddVO) {
        BaseExceptionCode baseExceptionCode = checkRoleValid(convertor.convertor(roleAddVO, SysRoleDTO.class));
        if (baseExceptionCode != null) {
            return Result.fail(baseExceptionCode);
        }
        SysRoleDTO roleDTO = convertor.convertor(roleAddVO, SysRoleDTO.class);
        roleDTO.setDelFlag(0);
        roleDTO.setCreateTime(new Date());
        roleMapper.insert(roleDTO);
        return Result.renderSuccess(SystemConstants.ADD_SUCCESS_MSG);
    }

    @Override
    public Result delRole(Long id) {
        BizAssert.notNull(id);
        //逻辑删除
        // delRole.setId(id);
        // delRole.setDelFlag(1);
        // updateById有更新策略的影响，不建议使用
        // roleMapper.updateById(delRole);
        roleMapper.update(null, Wrappers.<SysRoleDTO>lambdaUpdate().set(SysRoleDTO::getDelFlag,1).eq(SysRoleDTO::getId,id));
        return Result.renderSuccess(SystemConstants.DEL_FAIL_MSG);
    }
}
