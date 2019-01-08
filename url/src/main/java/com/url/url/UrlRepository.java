package com.url.url;

import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<Url,Long> {
  Url findByAlias(String alias);
}
