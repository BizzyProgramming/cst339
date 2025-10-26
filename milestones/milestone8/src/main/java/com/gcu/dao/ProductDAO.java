package com.gcu.dao;

import java.util.List;
import com.gcu.model.OrderModel;

/**
 * ProductDAO
 *
 * Defines methods for accessing product data from the database.
 * This interface separates database logic from the business layer
 * to promote maintainability and reusability.
 */
public interface ProductDAO {

    /**
     * Retrieves a list of all products in the database.
     *
     * @return a {@link List} of {@link OrderModel} objects
     */
    List<OrderModel> getProducts();
}