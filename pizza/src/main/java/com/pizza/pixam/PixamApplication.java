package com.pizza.pixam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PixamApplication implements CommandLineRunner {

  @Autowired
  private PizzaOrdersService pizzaOrdersService;

  public static void main(String[] args) {
    SpringApplication.run(PixamApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    pizzaOrdersService.saveOrder(new PizzaOrders("Sol", "Budapest","salami" ));
    pizzaOrdersService.saveOrder(new PizzaOrders("Enci", "Pecs","hawaii" ));
    pizzaOrdersService.saveOrder(new PizzaOrders("Manci", "London","gyros" ));
    pizzaOrdersService.saveOrder(new PizzaOrders("Bla", "London","salami" ));
    pizzaOrdersService.saveOrder(new PizzaOrders("Bla", "London","salami" ));
    pizzaOrdersService.saveOrder(new PizzaOrders("Bla", "London","hawaii" ));
    pizzaOrdersService.saveOrder(new PizzaOrders("Bla", "London","chicken" ));
    pizzaOrdersService.saveOrder(new PizzaOrders("Bla", "London","hawaii" ));
    pizzaOrdersService.saveOrder(new PizzaOrders("Bla", "London","chicken" ));
    pizzaOrdersService.saveOrder(new PizzaOrders("Bla", "London","salami" ));

  }
}

