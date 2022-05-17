package com.boot.study.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.boot.study.bean.Result;
import com.boot.study.constant.RedisCacheConstant;
import com.boot.study.entity.LoginUser;
import com.boot.study.entity.TBootUser;
import com.boot.study.service.LoginService;
import com.boot.study.util.JwtUtils;
import com.boot.study.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 登录Service实现
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    @Override
    public Result login(TBootUser user) {
        // 用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);// 帮助认证，调用userDetailsService中的方法去认证
        // 认证未通过
        if (ObjectUtil.isNull(authenticate)) {
            throw new RuntimeException("登录失败！");
        }
        // 认证通过，用户信息存入redis
        LoginUser principal = (LoginUser) authenticate.getPrincipal();
        Long id = principal.getUser().getId();
        String jwtToken = JwtUtils.getJwtToken(id.toString(), principal.getUsername());
        Map<String, String> map = CollUtil.newHashMap();
        map.put("token", jwtToken);
        // 存入redis
        redisCache.setCacheObject(RedisCacheConstant.LOGIN_CACHE_PREFIX + id.toString(), principal);
        return Result.renderSuccess(map, "登录成功！");
    }

    @Override
    public Result logout() {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser principal = (LoginUser) authentication.getPrincipal();
        Long userId = principal.getUser().getId();
        redisCache.deleteObject(RedisCacheConstant.LOGIN_CACHE_PREFIX + userId.toString());
        return Result.renderSuccess("注销成功！");
    }
}
