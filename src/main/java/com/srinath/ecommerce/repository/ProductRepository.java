package com.srinath.ecommerce.repository;

import com.srinath.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A repository interface for Product entities.
 * Spring Data JPA will automatically provide an implementation for this interface,
 * allowing us to perform common database operations without writing any boilerplate code.
 * We extend JpaRepository, which gives us methods like save(), findAll(), findById(), etc.
 * The generic types are <Entity, PrimaryKeyType>, so we use <Product, Long>.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
