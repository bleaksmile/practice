package com.tourist.tourist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TouristController {
  @Autowired
  AttractionRepository attractionRepository;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model, @ModelAttribute Attraction attraction, @ModelAttribute("error") String error) {
    model.addAttribute("error", error);
    model.addAttribute("attraction", attraction);
    model.addAttribute("attractions", attractionRepository.findAll());
    return "index";
  }

  @PostMapping(value = "/add")
  public String add(RedirectAttributes redirectAttributes, @ModelAttribute Attraction attraction) {
      attractionRepository.save(attraction);
    return "redirect:/";
  }


  @GetMapping("/edit/{id}")
  public String editAttractionById(@PathVariable("id") Long id, Model model) {
    model.addAttribute("attractions", attractionRepository.findAll());
    model.addAttribute("attraction", attractionRepository.findById(id).get());
    return "index";
  }

  @GetMapping("/budge")
  @ResponseBody
  public ResponseEntity listAttractionsByCat(){
    FilteredAttractions filteredAttractions = new FilteredAttractions();
    filteredAttractions.getAttractions().add(attractionRepository.findByCategoryContainsOrderByPrice("restaurant").get(0));
    filteredAttractions.getAttractions().add(attractionRepository.findByCategoryContainsOrderByPrice("park").get(0));
    filteredAttractions.getAttractions().add(attractionRepository.findByCategoryContainsOrderByPrice("museum").get(0));

    return ResponseEntity.ok(filteredAttractions);
  }

}
