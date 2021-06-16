package com.yuki.springbootresource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello1")
    @PreAuthorize("hasAnyAuthority('p1')")
    public String hello1() {
        return "hello1";
    }

    @GetMapping("/hello2")
    @PreAuthorize("hasAnyAuthority('p2')")
    public String hello2() {
        return "hello2";
    }



}
