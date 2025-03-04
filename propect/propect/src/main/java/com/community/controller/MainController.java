package com.community.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    public String test(){
        System.out.println("hello");
        return "/index.html";
    }

    @GetMapping("/freeboard")
    public String selecFreeboard(){

        return "/freeboard.html";
    }
}
