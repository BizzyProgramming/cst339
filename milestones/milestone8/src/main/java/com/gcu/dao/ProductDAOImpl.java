package com.gcu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.gcu.dao.ProductDAO;
import com.gcu.model.OrderModel;

/**
 * ProductDAOImpl
 *
 * Implements {@link ProductDAO} using Spring’s {@link JdbcTemplate}
 * to query the database for product information.
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Retrieves all products from the "products" table.
     *
     * @return a {@link List} of {@link OrderModel} objects containing product data
     */
    @Override
    public List<OrderModel> getProducts() {
        String sql = "SELECT product_id AS id, product_name AS productName, price, quantity FROM products";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(OrderModel.class));
    }
}
