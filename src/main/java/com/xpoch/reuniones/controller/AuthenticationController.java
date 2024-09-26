package com.xpoch.reuniones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AuthenticationController {

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
