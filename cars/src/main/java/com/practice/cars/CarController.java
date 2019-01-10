package com.practice.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarController {

  @Autowired
  CarRepository carRepository;

  @RequestMapping(value = "/search")
  public String index(Model model, @RequestParam(value = "plate", required = false) String plate, @RequestParam(value = "police", required = false) String police, @RequestParam(value = "diplomat", required = false) String diplomat){
    if (plate != null) {
      if(carRepository.findByPlateContains(plate).isEmpty()){
        model.addAttribute("error", "Sorry, the submitted licence plate is not valid!");
      } else{
        model.addAttribute("cars", carRepository.findByPlateContains(plate));
      }
    } else if(police !=null) {
      model.addAttribute("cars", carRepository.findByPlateStartsWith("RB"));
    } else if(diplomat!=null) {
      model.addAttribute("cars", carRepository.findByPlateStartsWith("DT"));
    } else{
      model.addAttribute("cars", carRepository.findAll());
    }
    return "index";
  }


  @RequestMapping(value = "/search/{brand}")
  public String brands(Model model, @PathVariable(value = "brand") String brand) {
    if (brand != null) {
      model.addAttribute("cars", carRepository.findByBrandContains(brand));
    } else {
      model.addAttribute("cars", carRepository.findAll());
    }
    return "index";
  }

  @RequestMapping(value = "/api/search/{brand}")
  @ResponseBody
  public ResponseEntity responseWithBrand(@PathVariable("brand") String brand){
    ResponseResult result = new ResponseResult();
    if(!carRepository.findByBrandContains(brand).isEmpty()){
      result.setResult("ok");
      result.setData(carRepository.findByBrandContains(brand));
    } else{
      result.setResult("not ok");
    }
    return ResponseEntity.ok(result);

  }

}
