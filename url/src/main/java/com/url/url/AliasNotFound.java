package com.url.url;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AliasNotFound extends RuntimeException{

  public AliasNotFound(String message) {
    super(message);
  }
}
