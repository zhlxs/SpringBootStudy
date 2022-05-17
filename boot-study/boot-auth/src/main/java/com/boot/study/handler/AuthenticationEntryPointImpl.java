package com.boot.study.handler;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.boot.study.bean.Result;
import com.boot.study.util.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) {
        log.info("======================AuthenticationEntryPoint=========================");
        Result result = Result.renderError(String.valueOf(HttpStatus.HTTP_UNAUTHORIZED), "用户认证失败！");
        String jsonString = JSON.toJSONString(result);
        WebUtil.renderString(httpServletResponse, jsonString);
    }
}
