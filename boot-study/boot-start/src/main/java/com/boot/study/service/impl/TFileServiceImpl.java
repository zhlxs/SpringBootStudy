package com.boot.study.service.impl;

import com.boot.study.dto.TFileDTO;
import com.boot.study.dao.TFileMapper;
import com.boot.study.service.TFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件业务表 服务实现类
 * </p>
 *
 * @author 胡山林
 * @since 2022-09-03
 */
@Service
public class TFileServiceImpl extends ServiceImpl<TFileMapper, TFileDTO> implements TFileService {

}
