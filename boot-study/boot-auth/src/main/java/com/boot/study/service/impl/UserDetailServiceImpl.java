package com.boot.study.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boot.study.dao.TBootUserMapper;
import com.boot.study.entity.LoginUser;
import com.boot.study.entity.TBootUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private TBootUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // 查询用户信息
        LambdaQueryWrapper<TBootUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TBootUser::getUserName, userName);
        TBootUser user = userMapper.selectOne(wrapper);
        if (ObjectUtil.isEmpty(user)) {
            throw new RuntimeException("用户名或者密码错误！");
        }
        // 查询权限信息 todo
        // 把数据封装成userDetails返回
        return new LoginUser(user);
    }
}
