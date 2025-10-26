package com.gcu.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.gcu.model.OrderModel;
import com.gcu.model.OrdersList;

/**
 * OrdersRestService
 * 
 * RESTful web service that provides access to order and product data.
 * This service exposes endpoints that return data in both JSON and XML formats.
 * 
 * Responsibilities:
 * <ul>
 *   <li>Provide a REST API for external systems to access product data.</li>
 *   <li>Support JSON and XML output for client compatibility.</li>
 *   <li>Delegate data retrieval to the {@link ProductBusinessInterface} layer.</li>
 * </ul>
 */
@RestController
@RequestMapping("/service")
public class OrdersRestService {

    /**
     * Business service responsible for fetching product data.
     */
    private final ProductBusinessInterface service;

    /**
     * Constructor-based dependency injection for the ProductBusinessInterface.
     *
     * @param service the injected business service used for accessing products
     */
    @Autowired
    public OrdersRestService(ProductBusinessInterface service) {
        this.service = service;
    }

    /**
     * Returns all product records as JSON.
     * 
     * <p>Example request:</p>
     * <pre>GET http://localhost:8080/service/getjson</pre>
     *
     * @return a {@link List} of {@link OrderModel} objects in JSON format
     */
    @GetMapping(path = "/getjson", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderModel> getOrdersAsJson() {
        return service.getAllProducts();
    }

    /**
     * Returns all product records as XML.
     * 
     * <p>Example request:</p>
     * <pre>GET http://localhost:8080/service/getxml</pre>
     *
     * @return an {@link OrdersList} object containing a list of {@link OrderModel} items
     */
    @GetMapping(path = "/getxml", produces = MediaType.APPLICATION_XML_VALUE)
    public OrdersList getOrdersAsXml() {
        OrdersList list = new OrdersList();
        list.setOrders(service.getAllProducts());
        return list;
    }
}