package com.boot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootStartApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BootStartApplication.class, args);
    }
}
