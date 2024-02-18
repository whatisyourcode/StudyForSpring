package com.example.firstproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FisrtApiController {
    @GetMapping("/api/hello")
    public String hello(){
        return "Hello World!";
    }
}
