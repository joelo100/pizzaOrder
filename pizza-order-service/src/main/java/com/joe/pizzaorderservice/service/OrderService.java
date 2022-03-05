package com.joe.pizzaorderservice.service;

import com.joe.pizzaorderservice.models.PizzaOrder;
import com.joe.pizzaorderservice.repository.PizzaOrderRepository;
import com.joe.pizzaorderservice.resources.OrderResource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    PizzaOrderRepository pizzaOrderRepository;

    Logger logger = LogManager.getLogger(OrderService.class);

   public ResponseEntity<PizzaOrder>createOrder(PizzaOrder order) {

       try {
           PizzaOrder pizzaOrder = pizzaOrderRepository
                   .save(order);
           logger.info("Order created " + pizzaOrder);
           return new ResponseEntity<>(pizzaOrder, HttpStatus.CREATED);

       } catch (Exception e) {
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }
}
