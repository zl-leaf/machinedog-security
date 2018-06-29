package me.yipzale.machinedog.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "/")
    public String hello() {
        return "hello";
    }
}
