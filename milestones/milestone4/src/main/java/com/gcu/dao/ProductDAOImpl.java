package com.gcu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.gcu.dao.ProductDAO;
import com.gcu.model.OrderModel;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
public List<OrderModel> getProducts() {
    String sql = "SELECT product_id AS id, product_name AS productName, price, quantity FROM products";
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(OrderModel.class));
}
    }
