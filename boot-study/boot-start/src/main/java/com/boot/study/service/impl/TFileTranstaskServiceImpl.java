package com.boot.study.service.impl;

import com.boot.study.dto.TFileTranstaskDTO;
import com.boot.study.dao.TFileTranstaskMapper;
import com.boot.study.service.TFileTranstaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件转码任务表(定时任务) 服务实现类
 * </p>
 *
 * @author 胡山林
 * @since 2022-09-03
 */
@Service
public class TFileTranstaskServiceImpl extends ServiceImpl<TFileTranstaskMapper, TFileTranstaskDTO> implements TFileTranstaskService {

}
