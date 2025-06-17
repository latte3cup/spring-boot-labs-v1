package com.example.handson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.handson.mapper")
public class HandsOnApplication {

    public static void main(String[] args) {
        SpringApplication.run(HandsOnApplication.class, args);
    }

}
