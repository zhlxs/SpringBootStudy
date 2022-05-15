package com.boot.study.service;

import com.boot.study.bean.Result;
import com.boot.study.entity.TBootUser;

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
    Result login(TBootUser user);
}
