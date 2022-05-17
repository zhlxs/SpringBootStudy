package com.boot.study.service;

import com.boot.study.bean.Result;
import com.boot.study.entity.SysUser;

/**
 * 登录Service
 */
public interface LoginService {

    /**
     * 登录
     *
     * @param user
     * @return
     */
    Result login(SysUser user);

    /**
     * 退出登录
     * @return
     */
    Result logout();
}
