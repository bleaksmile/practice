package com.pizza.pixam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PizzaOrdersRepository extends CrudRepository<PizzaOrders, Long> {

 @Query(value = "SELECT pizza FROM pizza_orders GROUP BY pizza ORDER BY COUNT(pizza)DESC LIMIT 3", nativeQuery = true)
  List<String> findMostOrderedPizzas();

 }
