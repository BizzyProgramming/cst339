package com.gcu.business;

import java.util.ArrayList;
import java.util.List;
// Spring annotations
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

// DAO
import com.gcu.dao.ProductDAO;
import com.gcu.model.OrderModel;

@Service // Marks this as a Spring service bean
public class OrdersBusinessService implements OrdersBusinessInterface {

    @Autowired
    private ProductDAO productDAO; // Inject ProductDAO for fetching products

    @Override
    public void test() {
        System.out.println("Hello from OrdersBusinessService");
    }

    @Override
    public void init() {
        System.out.println("Init method called in OrdersBusinessService");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method called in OrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        // Fetch all products from the database using the DAO
        return productDAO.getProducts();
    }
}



