package com.gcu.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.gcu.model.OrderModel;

/**
 * ProductRestService
 * 
 * REST controller that exposes endpoints for accessing product data.
 * Provides both a full product list and individual product retrieval in JSON format.
 * 
 * Responsibilities:
 * <ul>
 *   <li>Provide REST endpoints for external clients and API integration.</li>
 *   <li>Retrieve product data through the {@link ProductBusinessInterface} layer.</li>
 *   <li>Return data in a standard JSON response format.</li>
 * </ul>
 *
 * Example endpoints:
 * <ul>
 *   <li><b>GET</b> /service/products → returns all products</li>
 *   <li><b>GET</b> /service/product/{id} → returns one product by ID</li>
 * </ul>
 */
@RestController
@RequestMapping("/service")
public class ProductRestService {

    /**
     * The business service used to handle product data retrieval.
     */
    private final ProductBusinessInterface productService;

    /**
     * Constructor-based dependency injection of the business layer.
     *
     * @param productService the business service used to interact with the database
     */
    @Autowired
    public ProductRestService(ProductBusinessInterface productService) {
        this.productService = productService;
    }

    /**
     * REST API – Returns all available products as JSON.
     *
     * <p><b>Example:</b></p>
     * <pre>GET http://localhost:8080/service/products</pre>
     *
     * @return a {@link List} of {@link OrderModel} objects representing all available products
     */
    @GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderModel> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * REST API – Returns one product by its ID as JSON.
     *
     * <p><b>Example:</b></p>
     * <pre>GET http://localhost:8080/service/product/1</pre>
     *
     * @param id the product ID
     * @return the {@link OrderModel} matching the given ID, or {@code null} if not found
     */
    @GetMapping(path = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderModel getProductById(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }
}