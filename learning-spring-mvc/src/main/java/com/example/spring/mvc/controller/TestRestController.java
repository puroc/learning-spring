package com.example.spring.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by puroc on 2017/9/8.
 */
@Controller
public class TestRestController {

    @RequestMapping(value = "hello")
    public ResponseEntity<String> hello(){
        System.out.println("abbb");
        return new ResponseEntity<String>("haha", HttpStatus.OK);
    }
}
