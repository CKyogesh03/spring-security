package com.security.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyappController {
    @GetMapping("/hii")
    public String sayHii(){
        return "hii everyone";
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "hello everyone";
    }

    @GetMapping("/bye")
    public String saybye(){
        return "bye everyone";
    }
}