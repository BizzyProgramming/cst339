package com.gcu.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.dao.ProductDAO;
import com.gcu.model.OrderModel;

/**
 * ProductBusinessService
 * 
 * Implements {@link ProductBusinessInterface} and contains business logic
 * for retrieving and managing products. This class acts as the intermediary
 * between the controllers and the {@link ProductDAO} data access layer.
 * 
 * Responsibilities:
 * <ul>
 *   <li>Retrieve product data from the database through the DAO layer.</li>
 *   <li>Apply any necessary business rules or processing.</li>
 *   <li>Provide consistent and reusable access to product data across the application.</li>
 * </ul>
 */
@Service
public class ProductBusinessService implements ProductBusinessInterface {

    /**
     * DAO that provides direct access to the "products" table in the database.
     */
    @Autowired
    private ProductDAO productDAO;

    /**
     * Called when the service initializes.
     * Used for logging or setup tasks.
     */
    @Override
    public void init() {
        System.out.println("ProductBusinessService initialized");
    }

    /**
     * Called when the service shuts down.
     * Used for cleanup or releasing resources.
     */
    @Override
    public void destroy() {
        System.out.println("ProductBusinessService destroyed");
    }

    /**
     * Retrieves all products by delegating the call to {@link ProductDAO}.
     *
     * @return a {@link List} of {@link OrderModel} objects representing available products
     */
    @Override
    public List<OrderModel> getAllProducts() {
        return productDAO.getProducts();
    }

    /**
     * Retrieves a single product by its unique ID.
     * 
     * <p>Since {@link ProductDAO} currently returns all products as a list,
     * this method uses a Stream filter to find the matching product.</p>
     *
     * @param id the product ID to search for
     * @return the {@link OrderModel} matching the given ID, or {@code null} if not found
     */
    @Override
    public OrderModel getProductById(int id) {
        return productDAO.getProducts()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
}