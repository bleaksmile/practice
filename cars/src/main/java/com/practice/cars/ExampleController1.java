package com.practice.cars;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController1 {

  private CarRepository carRepository;

  @GetMapping("/example")
  public String example(){
    System.out.println(carRepository);
    return "example";
  }

}
