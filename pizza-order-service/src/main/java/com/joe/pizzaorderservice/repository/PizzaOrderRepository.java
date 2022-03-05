package com.joe.pizzaorderservice.repository;

import java.util.List;

import com.joe.pizzaorderservice.models.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Long> {
    List<PizzaOrder> findAll();
}
