package com.caneron.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/admin")
    public String admin() {

        return "Admin sayfası, Hoşgeldiniz.";
    }

    @GetMapping("/index")
    public String index() {

        return "Index Sayfası, Hoşgeldiniz.";
    }

    @GetMapping("/dashboard")
    public String dashboard() {

        return "Login başarılı, Dashboard sayfası.";
    }
}
