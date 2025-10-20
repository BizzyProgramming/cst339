package com.gcu.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.gcu.model.OrderModel;

/**
 * ProductRestService
 * 
 * This REST controller exposes two endpoints:
 *   /service/products   → Returns all products (JSON)
 *   /service/product/{id} → Returns one product (JSON)
 */
@RestController // Marks this as a REST API controller.
@RequestMapping("/service") // Prefix for all endpoints in this controller.
public class ProductRestService {

    // Injects the ProductBusinessService for database access.
    private final ProductBusinessInterface productService;

    @Autowired
    public ProductRestService(ProductBusinessInterface productService) {
        this.productService = productService;
    }

    /**
     * REST API 1 – Returns all products in JSON.
     * Example: GET http://localhost:8080/service/products
     */
    @GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderModel> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * REST API 2 – Returns one product by ID in JSON.
     * Example: GET http://localhost:8080/service/product/1
     */
    @GetMapping(path = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderModel getProductById(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }
}
