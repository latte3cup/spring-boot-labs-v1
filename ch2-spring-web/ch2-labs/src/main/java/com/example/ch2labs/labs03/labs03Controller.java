package com.example.ch2labs.labs03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@ResponseBody
@RestController
public class labs03Controller {

    @GetMapping("/random")
    public Map<String, Object> getRandom(@RequestParam int min, @RequestParam int max) {
        int interval = max - min + 1;
        Random rand = new Random();
        int number = rand.nextInt(interval) + min;
        Map<String, Object> response = new HashMap<>();
        response.put("number", number);
        return response;

    }
}
