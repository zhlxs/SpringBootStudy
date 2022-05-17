package com.boot.study.entity;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 登录用户信息
 */
@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {

    private SysUserDTO user;

    private List<String> permissions;

    @JSONField(serialize = false)
    private List<SimpleGrantedAuthority> authorities;//不需要序列化到redis中

    public LoginUser(SysUserDTO user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    // 用户返回权限信息的
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> list = new ArrayList<>();
//        for (String permission : permissions) {
//            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission);
//            list.add(grantedAuthority);
//        }
//        return list;
        if (CollUtil.isNotEmpty(authorities)) return authorities;
        authorities = permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        // 密码是加密存储的，如果未采用加密，要在明文密码前加上"{noop}"
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
