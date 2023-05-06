package com.example.courseapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //@RequestMapping are only for get requests
    @RequestMapping("/hello")
    public String say(){
        return "Hello";
    }
}
