package com.srinath.ecommerce.controller;

import com.srinath.ecommerce.model.ContactForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @PostMapping("/contact")
    public String submitContactForm(@RequestBody ContactForm contactForm) {
        System.out.println("Received contact form submission:");
        System.out.println("Name: " + contactForm.getName());
        System.out.println("Email: " + contactForm.getEmail());
        System.out.println("Message: " + contactForm.getMessage());
        return "Form submitted successfully!";
    }
}
