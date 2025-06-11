package com.example.firstapp.controller;

import com.example.firstapp.component.HelloComponentBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloComponentController {
    private final HelloComponentBean comp;

    public HelloComponentController(HelloComponentBean comp) {
        this.comp = comp;
    }
    @GetMapping("/hello")
    public String hello() {
        return comp.sayHello();
    }
}
