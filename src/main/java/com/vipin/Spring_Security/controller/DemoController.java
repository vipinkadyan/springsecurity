package com.vipin.Spring_Security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/showMyLoginPage")
    public String showLogin(){
        return "plain-login";
    }

    @PostMapping("logout")
    public String logoutPage(){
        return "plain-login";
    }
}
