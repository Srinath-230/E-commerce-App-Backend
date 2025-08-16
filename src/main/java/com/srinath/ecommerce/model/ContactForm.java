package com.srinath.ecommerce.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactForm {

    private String name;
    private String email;
    private String message;
}
