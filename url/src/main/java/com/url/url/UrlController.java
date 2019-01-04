package com.url.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UrlController {

  @Autowired
  UrlRepository urlRepository;

  @GetMapping("/")
  public String index(Model model, @ModelAttribute(name="url") Url url, @ModelAttribute(name="error") String error, @ModelAttribute(name="message")String message){
  model.addAttribute("url", url);
  model.addAttribute("error", error);
  model.addAttribute("message", message);
    return "index";
  }

  @PostMapping("/save-link")
  public String save(RedirectAttributes attributes, @ModelAttribute(name="url") Url url){
    System.out.println(url.getSecretCode());
    if(urlRepository.findByAlias(url.getAlias())!= null){
      attributes.addFlashAttribute("error", "Your alias is already in use!" );
    } else {
      url.setSecretCode((int)(Math.random()*10) +""+ (int)(Math.random()*10) +""+ (int)(Math.random()*10)+ ""+ (int)(Math.random()*10));
      urlRepository.save(url);
      attributes.addFlashAttribute("message", "Your url is aliased to " + url.getAlias() + " and your secret code is " + url.getSecretCode());
    }
    return "redirect:/";
  }

  @GetMapping("/a/{alias}")
  public String aliasCounter(@PathVariable(name="alias") String alias ){
    Url urlToFind = urlRepository.findByAlias(alias);
    urlToFind.setHitCount(urlToFind.getHitCount()+1);
    urlRepository.save(urlToFind);
    return "redirect:"+urlToFind.getUrl();
  }

  @GetMapping("/api/links")
  @ResponseBody
  public List<Url> responseWithEntries(){
    return (List<Url>) urlRepository.findAll();
  }
}
