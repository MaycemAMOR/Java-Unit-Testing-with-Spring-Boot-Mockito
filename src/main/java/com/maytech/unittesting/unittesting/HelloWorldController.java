package com.maytech.unittesting.unittesting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    String helloWorld(){
        return "Hello World";
    }
}
