package com.pizza.pixam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaOrdersService {
  @Autowired
  private PizzaOrdersRepository pizzaOrdersRepository;

  public Iterable<PizzaOrders> findAllOrders(){
    return pizzaOrdersRepository.findAll();
  }

  public void saveOrder(PizzaOrders pizzaOrders){
    pizzaOrdersRepository.save(pizzaOrders);
  }

  public PizzaOrders findById(Long id){
    return pizzaOrdersRepository.findById(id).get();
  }

  public List<String> mostWantedPizzas(){
    return pizzaOrdersRepository.findMostOrderedPizzas();
  }
}
