package com.lpu.springBootFundamentals.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodMorning {

    @GetMapping("/wish")
    public String wish(){
        return "Good Morning Varun Bro!";
    }
}
