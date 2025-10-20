package com.gcu.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.dao.ProductDAO;
import com.gcu.model.OrderModel;

/**
 * ProductBusinessService
 * 
 * This class implements the ProductBusinessInterface and handles business logic 
 * related to retrieving products from the database. It interacts with the DAO 
 * layer (ProductDAO) to fetch data and provides it to the controller or REST layer.
 * 
 * Responsibilities:
 *  - Interact with the ProductDAO to retrieve product data.
 *  - Contain any business rules or logic before returning data to the controller.
 *  - Maintain separation of concerns between the DAO and web layers.
 */
@Service // Marks this as a Spring-managed service bean.
public class ProductBusinessService implements ProductBusinessInterface {

    // Injects the DAO that interacts directly with the MySQL "products" table.
    @Autowired
    private ProductDAO productDAO;

    /**
     * Logs or initializes any resources when this service starts up.
     */
    @Override
    public void init() {
        System.out.println("ProductBusinessService initialized");
    }

    /**
     * Logs cleanup activity or releases resources when the service shuts down.
     */
    @Override
    public void destroy() {
        System.out.println("ProductBusinessService destroyed");
    }

    /**
     * Retrieves all products from the database by delegating the call to ProductDAO.
     * 
     * @return a List of OrderModel objects representing all products.
     */
    @Override
    public List<OrderModel> getAllProducts() {
        return productDAO.getProducts(); // Calls the DAO method to get all products.
    }

    /**
     * Retrieves a single product by its ID.
     * 
     * Since ProductDAO currently returns all products as a list, this method
     * filters that list using a Stream to find the specific product.
     * 
     * @param id The product ID.
     * @return The matching product or null if not found.
     */
    @Override
    public OrderModel getProductById(int id) {
        return productDAO.getProducts()
                .stream()
                .filter(p -> p.getId() == id) // Find product with matching ID.
                .findFirst()
                .orElse(null); // Return null if not found.
    }
}