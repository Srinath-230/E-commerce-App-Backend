package com.srinath.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginSuccessController {

    /**
     * This controller provides a clear, separate landing page after a successful login.
     * The `defaultSuccessUrl` in SecurityConfig.java will now redirect here,
     * ensuring there are no redirect loops.
     */
    @GetMapping("/login-success")
    public String loginSuccessRedirect() {
        // Redirect to a specific API endpoint after successful login.
        // The client-side (browser) will then make a new request to this URL.
        return "redirect:/api/products";
    }
}
