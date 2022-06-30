package com.boot.job;

import com.boot.job.utils.ApplicationStartUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 定时任务启动类
 */
@SpringBootApplication(scanBasePackages = {"com.boot", "com.xxl.job"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.boot", "com.xxl.job"})
public class XxlJobApplication {

    public static void main(String[] args) {
        ApplicationStartUtil.startServiceApplication(XxlJobApplication.class, args);
    }
}
