package com.boot.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.study.dao.SysUserMapper;
import com.boot.study.entity.SysUserDTO;
import com.boot.study.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author 胡山林
 * @since 2022-05-15
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserDTO> implements SysUserService {

}
