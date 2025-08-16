package com.srinath.ecommerce.controller;

import com.srinath.ecommerce.model.CartItem;
import com.srinath.ecommerce.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * A REST controller to handle shopping cart-related API requests.
 * This controller provides endpoints to manage cart items.
 */
@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartItemRepository cartItemRepository;

    /**
     * Handles HTTP GET requests to retrieve all items in the cart.
     * The endpoint is accessible at /api/cart
     * @return a List of all CartItem objects.
     */
    @GetMapping
    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    /**
     * Handles HTTP POST requests to add a new item to the cart.
     * The endpoint is /api/cart
     * @param cartItem The CartItem object from the request body.
     * @return the newly created CartItem object.
     */
    @PostMapping
    public CartItem addCartItem(@RequestBody CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    /**
     * Handles HTTP DELETE requests to remove an item from the cart.
     * The endpoint is /api/cart/{id}
     * @param id The ID of the item to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteCartItem(@PathVariable Long id) {
        cartItemRepository.deleteById(id);
    }
}
