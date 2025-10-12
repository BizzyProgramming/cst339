package com.gcu.dao;

import java.util.List;
import com.gcu.model.OrderModel;

public interface ProductDAO {
    List<OrderModel> getProducts();
}