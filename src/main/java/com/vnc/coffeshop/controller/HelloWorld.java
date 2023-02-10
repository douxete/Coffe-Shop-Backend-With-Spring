package com.vnc.coffeshop.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    String hello(){
        return "Hello World";
    }

    // path variable
    @GetMapping("/hello/{var}")
    public String pathVar(@PathVariable String var){
        return "Path var: " + var;
    }

    // query string
    @GetMapping("/req")
    public String queryStr(@RequestParam String var){
        return "Request Param: " + var;
    }

    // request body
    @PostMapping("/hello-body")
    public String reqBody(@RequestBody HashMap<String, String> mapBody){
        return "Request Body: " + mapBody;
    }

}
