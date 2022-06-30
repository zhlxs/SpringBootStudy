package com.boot.job.web;

import com.boot.job.service.XxlJobService;
import com.boot.job.vo.JobQueryVO;
import com.boot.study.bean.Result;
import com.boot.study.exception.BizException;
import com.xxl.job.api.bean.SaveXxlJobDTO;
import com.xxl.job.api.bean.UpdateXxlJobDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "定时任务模块")
@Slf4j
@RestController
@RequestMapping("/api/job")
public class XxlJobController {

    @Autowired
    private XxlJobService xxlJobService;

    @ApiOperation("分页查询")
    @PostMapping("/page")
    public Result search(@RequestBody JobQueryVO jobQueryVO) {
        Result result = xxlJobService.pager(jobQueryVO);
        if (result.getSuccess()) {
            return result;
        }
        throw BizException.wrap(result.getCode(), result.getMessage());
    }

    @ApiOperation("新增任务")
    @PostMapping("/create")
    public Result create(@Valid @RequestBody SaveXxlJobDTO saveXxlJobDTO) {
        Result result = xxlJobService.add(saveXxlJobDTO);
        if (result.getSuccess()) {
            return result;
        }
        throw BizException.wrap(result.getCode(), result.getMessage());
    }

    @ApiOperation("修改任务")
    @PostMapping("/update")
    public Result update(@Valid @RequestBody UpdateXxlJobDTO updateXxlJobDTO) {
        Result result = xxlJobService.update(updateXxlJobDTO);
        if (result.getSuccess()) {
            return result;
        }
        throw BizException.wrap(result.getCode(), result.getMessage());
    }

    @ApiOperation("单个删除")
    @PostMapping("/del")
    public Result del(Long id) {
        Result result = xxlJobService.delete(id);
        if (result.getSuccess()) {
            return result;
        }
        throw BizException.wrap(result.getCode(), result.getMessage());
    }

    @ApiOperation("启动任务")
    @PostMapping("/start")
    public Result start(Long id) {
        Result result = xxlJobService.start(id);
        if (result.getSuccess()) {
            return result;
        }
        throw BizException.wrap(result.getCode(), result.getMessage());
    }

    @ApiOperation("停止任务")
    @PostMapping("/stop")
    public Result stop(Long id) {
        Result result = xxlJobService.stop(id);
        if (result.getSuccess()) {
            return result;
        }
        throw BizException.wrap(result.getCode(), result.getMessage());
    }
}
