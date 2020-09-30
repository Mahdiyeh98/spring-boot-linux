package com.mapsa.springcloudlinux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
@RequestMapping("/")
public class HelloController {
    @GetMapping
    public String sayHello(){
        return "Salam Donya!";
    }
}
