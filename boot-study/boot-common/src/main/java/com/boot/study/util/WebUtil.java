package com.boot.study.util;

import cn.hutool.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

public class WebUtil {

    /**
     * 渲染字符串到客户端
     *
     * @param response
     * @param result
     * @return
     */
    public static String renderString(HttpServletResponse response, String result) {
        try {
            response.setStatus(HttpStatus.HTTP_OK);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
