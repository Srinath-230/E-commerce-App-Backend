package com.srinath.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an item in the shopping cart.
 * This entity links to a product and stores the quantity.
 */
@Entity
@Data
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The ID of the product this cart item represents
    private Long productId;

    // The quantity of the product in the cart
    private int quantity;
}
