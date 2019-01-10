package com.pizza.pixam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;

@Controller
public class PizzaController {

  @Autowired
  private  PizzaOrdersService pizzaOrdersService;

  @GetMapping("/")
  public String index(Model model, @ModelAttribute PizzaOrders pizzaOrders){
    model.addAttribute("order", pizzaOrders);
    model.addAttribute("orders", pizzaOrdersService.findAllOrders());
    return "index";
  }

  @PostMapping("/order")
  public String saveOrder(@ModelAttribute PizzaOrders pizzaOrders){
    pizzaOrdersService.saveOrder(pizzaOrders);
    return "redirect:/";
  }


  //optional, not part of the exam
  @GetMapping("/edit/{id}")
  public String editOrder(Model model, @PathVariable Long id){
    model.addAttribute("order", pizzaOrdersService.findById(id));
    return "index";
  }

  @GetMapping("/order/{id}")
  public String details(Model model,@PathVariable Long id){
    model.addAttribute("order", pizzaOrdersService.findById(id));
    return "order";
  }

  @GetMapping("/api/orders/{id}")
  @ResponseBody
  public ResponseEntity returnOrder(@PathVariable Long id){
    PizzaOrders orderToFind = pizzaOrdersService.findById(id);
    return ResponseEntity.ok().body(orderToFind);
  }

 @GetMapping("/statistics")
  public String statitics(Model model){
  model.addAttribute("pizzas", pizzaOrdersService.mostWantedPizzas());
  return "statistics";
  }
}
