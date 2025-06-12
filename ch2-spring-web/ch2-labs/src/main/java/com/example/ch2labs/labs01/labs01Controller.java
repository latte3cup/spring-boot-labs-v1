package com.example.ch2labs.labs01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class labs01Controller {

    @GetMapping("/calc")
    @ResponseBody
    public String Calc(@RequestParam int x, @RequestParam int y,@RequestParam String op) {
        String res = switch(op){
            case "add" -> x + " + " + y + " = " + (x + y);
            case "sub" -> x + " - " + y + " = " + (x - y);
            case "mul" -> x + " * " + y + " = " + (x * y);
            case "div" -> x + " / " + y + " = " + (x / y);
            default -> "연산자 오류";
        };
        return "결과: " + res;


    }
}
