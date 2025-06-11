package com.example.firstapp.component;


import org.springframework.stereotype.Component;

@Component
public class HelloComponentBean {
    public String sayHello() {
        return "Hello from @Component!";
    }
}
