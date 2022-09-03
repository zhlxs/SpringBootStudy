package com.boot.study.service.impl;

import com.boot.study.dto.TVideoDTO;
import com.boot.study.dao.TVideoMapper;
import com.boot.study.service.TVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 视频信息表 服务实现类
 * </p>
 *
 * @author 胡山林
 * @since 2022-09-03
 */
@Service
public class TVideoServiceImpl extends ServiceImpl<TVideoMapper, TVideoDTO> implements TVideoService {

}
