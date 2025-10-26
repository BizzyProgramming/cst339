package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * OrdersList
 *
 * Wraps a list of {@link OrderModel} objects for XML serialization.
 * Used by REST services when responding with XML format.
 */
@XmlRootElement(name = "orders")
public class OrdersList {

    private List<OrderModel> orders = new ArrayList<>();

    /**
     * Returns the list of orders.
     *
     * @return a list of {@link OrderModel} objects
     */
    @XmlElement(name = "order")
    public List<OrderModel> getOrders() {
        return this.orders;
    }

    /**
     * Sets the list of orders.
     *
     * @param orders a list of {@link OrderModel} objects
     */
    public void setOrders(List<OrderModel> orders) {
        this.orders = orders;
    }
}
