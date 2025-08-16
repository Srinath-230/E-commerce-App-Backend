package com.srinath.ecommerce.repository;

import com.srinath.ecommerce.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A repository interface for CartItem entities.
 * Spring Data JPA will automatically provide an implementation for this interface,
 * allowing us to perform common database operations for shopping cart items.
 */
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
