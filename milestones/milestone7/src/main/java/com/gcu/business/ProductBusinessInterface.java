package com.gcu.business;

import java.util.List;
import com.gcu.model.OrderModel;

/**
 * The ProductBusinessInterface defines the contract for business logic
 * related to products. It specifies methods for initializing, destroying,
 * retrieving all products, and retrieving a single product by ID.
 */
public interface ProductBusinessInterface {

    // Called when the service starts (used for logging or initialization)
    void init();

    // Called when the service is destroyed (cleanup or shutdown logic)
    void destroy();

    // Returns a list of all products from the database
    List<OrderModel> getAllProducts();

    // Returns a specific product by its unique ID
    OrderModel getProductById(int id);
}