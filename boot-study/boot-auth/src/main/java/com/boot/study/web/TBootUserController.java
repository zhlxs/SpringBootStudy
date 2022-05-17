package com.boot.study.web;


import com.boot.study.bean.Result;
import com.boot.study.entity.SysUserDTO;
import com.boot.study.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author 胡山林
 * @since 2022-05-15
 */
@Api(tags = "用户模块")
@Slf4j
@RestController
@RequestMapping("/api/user")
public class TBootUserController {

    @Autowired
    private LoginService loginService;

    @ApiOperation("用户登录")
    @RequestMapping("/login")
    public Result login(@RequestBody SysUserDTO user) {
        return loginService.login(user);
    }

    @ApiOperation("退出登录")
    @RequestMapping("/logout")
    public Result logout(){
        return loginService.logout();
    }
}
