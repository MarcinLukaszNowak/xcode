package com.example.xcode.status.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("status")
public class StatusController {

    @GetMapping("ping")
    public String pingStatus() {
        return "pong";
    }

}
