package com.practice.cars;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

  private CarRepository carRepository;

  @GetMapping("/second")
  public String example(){
    System.out.println(carRepository.findAll());
    return "second";
  }
}
