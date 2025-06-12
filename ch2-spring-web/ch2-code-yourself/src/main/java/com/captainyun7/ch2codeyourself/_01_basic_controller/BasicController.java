package com.captainyun7.ch2codeyourself._01_basic_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class BasicController {

    @ResponseBody       ///  뷰 리졸브 X , 직접 응답 본문 반환
    @GetMapping("/basic/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/basic/users/{userId}")
    @ResponseBody
    public String users(@PathVariable int userId){
        return "users 아이디는 .. :" + userId;
    }
    @GetMapping("/basic/users/{userId}/orders/{orderId}")
    @ResponseBody
    public String orders(@PathVariable int userId, @PathVariable int orderId){
        return "user Id: " + userId + " order Id: " + orderId;
    }

    @GetMapping("/basic/params")
    @ResponseBody
    public String params(@RequestParam String name, @RequestParam int age){
        return "이름 : " + name + " 나이: " + age;
    }
    @GetMapping("/basic/filter")
    @ResponseBody
    public String filter(@RequestParam Map<String, String> params){
        return params.toString();

    }
    @PutMapping("/basic/users/{userId}")
    @ResponseBody
    public String put(){
        return "사용자 수정 성공";

    }
    @DeleteMapping("/basic/users/{userId}")
    @ResponseBody
    public String delete(){
        return "사용자 삭제 성공";

    }
}
