package com.srinath.ecommerce.controller;

import com.srinath.ecommerce.model.Product;
import com.srinath.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * A REST controller for handling product-related API requests.
 * The @RestController annotation combines @Controller and @ResponseBody,
 * meaning this class handles web requests and automatically converts return
 * objects to JSON responses.
 * The @RequestMapping annotation sets the base URL for all endpoints in this controller.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    // The @Autowired annotation tells Spring to automatically inject an instance
    // of ProductRepository, allowing us to interact with the database.
    @Autowired
    private ProductRepository productRepository;

    /**
     * Handles HTTP GET requests to retrieve all products.
     * The endpoint will be accessible at /api/products
     *
     * @return a List of all Product objects.
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Handles HTTP GET requests to retrieve a single product by its ID.
     * The endpoint will be accessible at /api/products/{id}, where {id} is the product's ID.
     * The @PathVariable annotation tells Spring to extract the ID from the URL.
     *
     * @param id The ID of the product to retrieve.
     * @return an Optional containing the Product object if found, or an empty Optional if not.
     */
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    /**
     * Handles HTTP POST requests to create a new product.
     * The endpoint is /api/products
     * The @RequestBody annotation tells Spring to convert the incoming JSON
     * request body into a Product object.
     *
     * @param product the Product object from the request body.
     * @return the newly created Product object, including its generated ID.
     */
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    /**
     * Handles HTTP PUT requests to update an existing product.
     * The endpoint is /api/products/{id}, where {id} is the product's ID.
     * It checks if the product exists before updating.
     *
     * @param id The ID of the product to update.
     * @param updatedProduct The updated product details from the request body.
     * @return a ResponseEntity with the updated product or a not found status.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Optional<Product> existingProductOptional = productRepository.findById(id);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            Product savedProduct = productRepository.save(existingProduct);
            return ResponseEntity.ok(savedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Handles HTTP DELETE requests to delete a product by its ID.
     * The endpoint is /api/products/{id}, where {id} is the product's ID.
     *
     * @param id The ID of the product to delete.
     * @return a ResponseEntity indicating success or not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
