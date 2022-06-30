//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.boot.job.utils;

import cn.hutool.core.net.NetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

public class ApplicationStartUtil {
    private static final Logger log = LoggerFactory.getLogger(ApplicationStartUtil.class);

    public ApplicationStartUtil() {
    }

    public static ConfigurableApplicationContext startServiceApplication(Class<?> primarySource, String... args) {
        ConfigurableApplicationContext application = SpringApplication.run(primarySource, args);
        Environment env = application.getEnvironment();
        log.info("\n----------------------------------------------------------\n\t应用 '{}' 运行成功，访问端口: {}，API文档访问地址：http://{}:{}/doc.html\n----------------------------------------------------------", new Object[]{env.getProperty("spring.application.name"), env.getProperty("server.port"), NetUtil.getLocalhostStr(), env.getProperty("server.port")});
        return application;
    }

    public static ConfigurableApplicationContext startBackendApplication(Class<?> primarySource, String... args) {
        ConfigurableApplicationContext application = SpringApplication.run(primarySource, args);
        Environment env = application.getEnvironment();
        log.info("\n----------------------------------------------------------\n\t http://{}:{}{} 运行成功\n----------------------------------------------------------", new Object[]{NetUtil.getLocalhostStr(), env.getProperty("server.port"), env.getProperty("server.servlet.context-path")});
        return application;
    }
}
