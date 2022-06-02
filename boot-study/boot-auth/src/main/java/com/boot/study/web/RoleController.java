package com.boot.study.web;

import com.boot.study.bean.PageQueryCondition;
import com.boot.study.bean.PageQueryResult;
import com.boot.study.bean.Result;
import com.boot.study.entity.SysRoleDTO;
import com.boot.study.exception.BizException;
import com.boot.study.service.SysRoleService;
import com.boot.study.vo.SysRoleAddVO;
import com.boot.study.vo.SysRoleUpdateVO;
import com.boot.study.vo.SysRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "角色模块")
@Slf4j
@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private SysRoleService roleService;

    @ApiOperation("分页查询")
    @PostMapping("/page")
    public PageQueryResult<SysRoleDTO> search(@RequestBody SysRoleVO queryRequest) {
        PageQueryCondition<SysRoleVO> pageQueryCondition = new PageQueryCondition<>();
        pageQueryCondition.setModel(queryRequest);
        if (queryRequest.getCurrent() != null) {
            pageQueryCondition.setCurrent(queryRequest.getCurrent());
        }
        if (queryRequest.getSize() != null) {
            pageQueryCondition.setSize(queryRequest.getSize());
        }
        PageQueryResult<SysRoleDTO> pager = roleService.pager(pageQueryCondition);
        pager.setSuccess(true);
        return pager;
    }

    @ApiOperation("角色查询")
    @GetMapping("/findById")
    public SysRoleDTO findById(@RequestParam("id") Long id) {
        return roleService.findById(id);
    }

    @ApiOperation("角色更新")
    @PostMapping("/update")
    public void update(@Valid @RequestBody SysRoleUpdateVO roleUpdateVO) {
        Result result = roleService.updateRole(roleUpdateVO);
        if (result.getSuccess()) {
            return;
        }
        throw BizException.wrap(result.getCode(), result.getMessage());
    }

    @ApiOperation("角色新增")
    @PostMapping("/create")
    public void create(@Valid @RequestBody SysRoleAddVO roleAddVO) {
        Result result = roleService.addRole(roleAddVO);
        if (result.getSuccess()) {
            return;
        }
        throw BizException.wrap(result.getCode(), result.getMessage());
    }

    @ApiOperation("角色删除")
    @PostMapping("/delete")
    public void delete(@RequestParam("id") Long id) {
        Result result = roleService.delRole(id);
        if (result.getSuccess()) {
            return;
        }
        throw BizException.wrap(result.getCode(), result.getMessage());
    }
}
