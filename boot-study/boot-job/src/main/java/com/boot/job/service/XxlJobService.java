package com.boot.job.service;

import com.boot.job.vo.JobQueryVO;
import com.boot.study.bean.Result;
import com.boot.study.constant.SystemConstants;
import com.xxl.job.api.bean.R;
import com.xxl.job.api.bean.SaveXxlJobDTO;
import com.xxl.job.api.bean.UpdateXxlJobDTO;
import com.xxl.job.api.service.XxlJobApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class XxlJobService {

    @Qualifier("com.xxl.job.api.service.XxlJobApi")
    @Autowired
    private XxlJobApi xxlJobApi;

    public Result pager(JobQueryVO params) {
        try {
            R r = xxlJobApi.pageList(params.getPageNum(), params.getPageSize(), params.getJobGroup(), params.getTriggerType(),
                    params.getTriggerStatus(), params.getJobDesc(), params.getExecutorHandler(), params.getAuthor());
            return Result.renderSuccess(r);
        } catch (Exception ex) {
            log.error("接口异常", ex);
            return Result.renderError(ex.getMessage());
        }
    }

    public Result add(SaveXxlJobDTO saveXxlJobDTO) {
        try {
            R r = xxlJobApi.addXxlJob(saveXxlJobDTO);
            return Result.renderSuccess(r, SystemConstants.ADD_SUCCESS_MSG);
        } catch (Exception ex) {
            log.error("接口异常", ex);
            return Result.renderError(ex.getMessage());
        }
    }

    public Result update(UpdateXxlJobDTO updateXxlJobDTO) {
        try {
            R r = xxlJobApi.updateXxlJob(updateXxlJobDTO);
            return Result.renderSuccess(r, SystemConstants.UPDATE_SUCCESS_MSG);
        } catch (Exception ex) {
            log.error("接口异常", ex);
            return Result.renderError(ex.getMessage());
        }
    }

    public Result delete(Long id) {
        try {
            if (id == null)
                throw new RuntimeException("id为空！");
            R r = xxlJobApi.delete(id);
            return Result.renderSuccess(r);
        } catch (Exception ex) {
            log.error("接口异常", ex);
            return Result.renderError(ex.getMessage());
        }
    }

    public Result start(Long id) {
        try {
            if (id == null)
                throw new RuntimeException("id为空！");
            R r = xxlJobApi.start(id);
            return Result.renderSuccess(r);
        } catch (Exception ex) {
            log.error("接口异常", ex);
            return Result.renderError(ex.getMessage());
        }
    }

    public Result stop(Long id) {
        try {
            if (id == null)
                throw new RuntimeException("id为空！");
            R r = xxlJobApi.stop(id);
            return Result.renderSuccess(r);
        } catch (Exception ex) {
            log.error("接口异常", ex);
            return Result.renderError(ex.getMessage());
        }
    }
}
