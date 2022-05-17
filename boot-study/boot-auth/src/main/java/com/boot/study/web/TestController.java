package com.boot.study.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('test')")
    public String hello() {
        return "hello";
    }
}
