package com.srinath.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    /**
     * This method handles GET requests to the application's root URL ("/").
     * The @RestController annotation tells Spring that this class
     * handles web requests and automatically converts the return value to JSON.
     *
     * @return A simple String message.
     */
    @GetMapping("/")
    public String home() {
        return "<h1>Welcome to the E-Commerce App! You are successfully logged in.</h1>";
    }
}
