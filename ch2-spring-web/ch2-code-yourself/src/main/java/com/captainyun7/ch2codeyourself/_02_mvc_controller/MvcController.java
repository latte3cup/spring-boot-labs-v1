package com.captainyun7.ch2codeyourself._02_mvc_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mvc")
public class MvcController {

    @GetMapping("/basic/view")
    public String basicView() {
        return "basic-view";
    }
    @GetMapping("/model")
    public String model(Model model) {
        model.addAttribute("msg", "Hello World");
        model.addAttribute("currentTime", java.time.LocalDateTime.now());
        return "model-view";
    }
}
