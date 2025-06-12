package com.example.ch2labs.labs02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@ResponseBody
@RestController
public class labs02Controller {

    @GetMapping("/dice")
    public Map<String, Object> dice() {
        Random rand = new Random();
        int roll = rand.nextInt(6) + 1;
        Map<String, Object> response = new HashMap<>();
        response.put("dice", roll);
        return response;

    }
}
