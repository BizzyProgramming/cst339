package com.gcu.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.gcu.model.OrderModel;
import com.gcu.model.OrdersList;

@RestController
@RequestMapping("/service")
public class OrdersRestService {

    // Inject the ProductBusinessService (Milestone 7 version)
    private ProductBusinessInterface service;

    // Constructor-based dependency injection
    @Autowired
    public OrdersRestService(ProductBusinessInterface service) {
        this.service = service;
    }

    /**
     * Returns all records as JSON
     * Example: GET http://localhost:8080/service/getjson
     */
    @GetMapping(path = "/getjson", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderModel> getOrdersAsJson() {
        // Updated to call the new Milestone 7 method
        return service.getAllProducts();
    }

    /**
     * Returns all records as XML
     * Example: GET http://localhost:8080/service/getxml
     */
    @GetMapping(path = "/getxml", produces = MediaType.APPLICATION_XML_VALUE)
    public OrdersList getOrdersAsXml() {
        OrdersList list = new OrdersList();

        // Updated to call the new Milestone 7 method
        list.setOrders(service.getAllProducts());

        return list;
    }
}
