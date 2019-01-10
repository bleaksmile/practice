package com.url.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class UrlController {

  @Autowired
  UrlRepository urlRepository;

  @GetMapping("/")
  public String index(Model model, @ModelAttribute(name = "url") Url url, @ModelAttribute(name = "error") String error, @ModelAttribute(name = "message") String message) {
    model.addAttribute("url", url);
    model.addAttribute("error", error);
    model.addAttribute("message", message);
    return "index";
  }

  @PostMapping("/save-link")
  public String save(RedirectAttributes attributes, @ModelAttribute(name = "url") Url url) {
    if (urlRepository.findByAlias(url.getAlias()) != null) {
      attributes.addFlashAttribute("error", "Your alias is already in use!");
    } else {
      url.setSecretCode((int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10));
      urlRepository.save(url);
      attributes.addFlashAttribute("message", "Your url is aliased to " + url.getAlias() + " and your secret code is " + url.getSecretCode());
    }
    return "redirect:/";
  }

  @GetMapping("/a/{alias}")
  public String aliasCounter(@PathVariable(name = "alias") String alias) {
    Url urlToFind = urlRepository.findByAlias(alias);
    if (urlToFind != null) {
      urlToFind.setHitCount(urlToFind.getHitCount() + 1);
      urlRepository.save(urlToFind);
      return "redirect:" + urlToFind.getLink();
    } else {
      throw new AliasNotFound("Alias not found");
    }
  }

  @GetMapping("/api/links")
  @ResponseBody
  public List<Url> responseWithEntries() {
    return (List<Url>) urlRepository.findAll();
  }

  @DeleteMapping("/api/links/{id}")
  public ResponseEntity delete(@PathVariable("id") Long id, @RequestBody SecretCodeObject secret) {
    Optional<Url> urlToFind = urlRepository.findById(id);
    if(!urlToFind.isPresent()){
      return  ResponseEntity.notFound().build();
    } else if (!urlToFind.get().getSecretCode().equals(secret.getSecretcode())) {
      return  ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    } else{
      urlRepository.delete(urlToFind.get());
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

  }

}
