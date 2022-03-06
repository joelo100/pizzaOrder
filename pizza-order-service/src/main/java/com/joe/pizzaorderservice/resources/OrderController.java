package com.joe.pizzaorderservice.resources;

import com.joe.pizzaorderservice.models.PizzaMessage;
import com.joe.pizzaorderservice.models.PizzaOrder;
import com.joe.pizzaorderservice.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/pizzaOrder")
public class OrderController {

    Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @PreAuthorize("hasAnyRole('AUTHORIZED_USER')")
    @RequestMapping("/orderSubmit")
    public ResponseEntity<PizzaOrder> submitPizzaOrder() {

        RestTemplate restTemplate  = new RestTemplate();

        PizzaMessage msg = restTemplate.getForObject("http://localhost:8081/pizzaMessage/pizza", PizzaMessage.class);

        return orderService.createOrder(new PizzaOrder(msg.getName(), msg.getQuantity(), msg.getPrice()));
    }

}
