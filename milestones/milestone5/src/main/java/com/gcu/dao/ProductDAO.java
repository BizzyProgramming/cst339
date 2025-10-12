package com.gcu.dao;

import java.util.List;
import com.gcu.model.OrderModel;

// DAO interface for fetching products/orders
public interface ProductDAO {
    // Return a list of all products
    List<OrderModel> getProducts();
}