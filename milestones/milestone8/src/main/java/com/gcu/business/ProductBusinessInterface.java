package com.gcu.business;

import java.util.List;
import com.gcu.model.OrderModel;

/**
 * ProductBusinessInterface
 *
 * Defines the contract for business logic related to product operations.
 * Classes implementing this interface are responsible for handling
 * product retrieval and other business-related tasks that interact
 * with the data access layer.
 */
public interface ProductBusinessInterface {

    /**
     * Initializes any required resources or logs service startup.
     */
    void init();

    /**
     * Performs cleanup or shutdown logic when the service is destroyed.
     */
    void destroy();

    /**
     * Retrieves a list of all products from the database.
     *
     * @return a {@link List} of {@link OrderModel} objects representing all products
     */
    List<OrderModel> getAllProducts();

    /**
     * Retrieves a specific product by its unique ID.
     *
     * @param id the ID of the product to retrieve
     * @return the {@link OrderModel} for the specified product ID, or {@code null} if not found
     */
    OrderModel getProductById(int id);
}