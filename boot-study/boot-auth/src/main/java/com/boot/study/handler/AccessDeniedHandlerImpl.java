package com.boot.study.handler;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.boot.study.bean.Result;
import com.boot.study.util.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) {
        log.info("======================AccessDeniedHandler=========================");
        Result result = Result.renderError(String.valueOf(HttpStatus.HTTP_FORBIDDEN), "权限不足！");
        String jsonString = JSON.toJSONString(result);
        WebUtil.renderString(httpServletResponse, jsonString);
    }
}
