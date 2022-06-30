package com.boot.job.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 定时任务查询参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobQueryVO {

    private Integer pageNum = 1;

    private Integer pageSize = 5;

    private Integer jobGroup;

    private Integer triggerType;

    private Integer triggerStatus;

    private String jobDesc;

    private String executorHandler;

    private String author;
}
