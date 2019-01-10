package com.url.url;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UrlRepository extends CrudRepository<Url,Long> {
  Url findByAlias(String alias);

}
