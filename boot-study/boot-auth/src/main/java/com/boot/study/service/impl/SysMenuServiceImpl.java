package com.boot.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.study.dao.SysMenuMapper;
import com.boot.study.entity.SysMenuDTO;
import com.boot.study.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author 胡山林
 * @since 2022-05-17
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuDTO> implements SysMenuService {

}
