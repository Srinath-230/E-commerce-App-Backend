package com.srinath.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SuccessController {

    @GetMapping("/success")
    @ResponseBody
    public String loginSuccess() {
        return "<h1>Login successful! You can now access the protected API.</h1>";
    }
}
