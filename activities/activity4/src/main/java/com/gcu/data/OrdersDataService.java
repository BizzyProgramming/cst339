package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import com.gcu.model.OrderModel;

@Service
public class OrdersDataService implements DataAccessInterface<OrderModel> {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	

	public OrdersDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<OrderModel> findAll() {
		String sql = "SELECT * FROM ORDERS";
		List<OrderModel> orders = new ArrayList<OrderModel>();
		try {
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while (srs.next()) {
				orders.add(new OrderModel(srs.getLong("ID"),
						srs.getString("ORDER_NO"),
						srs.getString("PRODUCT_NAME"),
						srs.getFloat("PRICE"),
						srs.getInt("QUANTITY")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	public OrderModel findById(int id) {
		return null;
	}

	public boolean create(OrderModel order) {
		String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)";
		try {
			int rows = jdbcTemplateObject.update(sql,
					order.getOrderNo(),
					order.getProductName(),
					order.getPrice(),
					order.getQuantity());
			return rows == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(OrderModel order) {
		return true;
	}

	public boolean delete(OrderModel order) {
		return true;
	}
}
