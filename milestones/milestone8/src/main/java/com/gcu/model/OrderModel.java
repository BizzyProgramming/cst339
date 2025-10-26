package com.gcu.model;

/**
 * OrderModel
 *
 * Represents a product or order entry retrieved from the database.
 * Used for displaying product information in the shop and order views.
 */
public class OrderModel {

    private int id;
    private String orderNo;
    private String productName;
    private float price;
    private int quantity;

    /** Default constructor (required for Spring/JDBC mapping). */
    public OrderModel() {}

    /**
     * Constructs an OrderModel with all fields initialized.
     *
     * @param id          unique product or order ID
     * @param orderNo     unique order number (if applicable)
     * @param productName the name of the product
     * @param price       the product’s price
     * @param quantity    how many units are available
     */
    public OrderModel(int id, String orderNo, String productName, float price, int quantity) {
        this.id = id;
        this.orderNo = orderNo;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getOrderNo() { return orderNo; }
    public void setOrderNo(String orderNo) { this.orderNo = orderNo; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
