package com.boot.study.filter;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.boot.study.constant.RedisCacheConstant;
import com.boot.study.entity.LoginUser;
import com.boot.study.util.JwtUtils;
import com.boot.study.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证过滤器,保证每个请求都只会经过这个过滤器一次
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        // 获取token，从请求头里面获取
        String token = request.getHeader("token");
        if (StrUtil.isBlank(token)) {
            // 放行（其他的过滤器会正常处理）
            filterChain.doFilter(request, response);
            // 防止响应时执行下面的代码
            return;
        }
        // 解析token
        String userId = JwtUtils.getUserIdByJwtToken(request);
        // 从redis中获取用户信息
        String key = RedisCacheConstant.LOGIN_CACHE_PREFIX + userId;
        LoginUser user = redisCache.getCacheObject(key);
        if (ObjectUtil.isNull(user)) {
            throw new RuntimeException("用户未登录！");
        }
        // 存入内存中（用三个参数的构造器）
        // TODO 获取权限信息
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
