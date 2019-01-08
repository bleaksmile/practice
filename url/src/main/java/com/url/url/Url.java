package com.url.url;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.net.URL;

@Entity
public class Url {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String alias;
  private URL link;
  private Integer hitCount;
  @JsonIgnore
  private String secretCode;

  public Url() {
    this.hitCount = 0;
  }

  public Url(URL url, String alias) {
    this();
    this.link = url;
    this.alias = alias;
  }

  public URL getLink() {
    return link;
  }

  public void setLink (URL url) {
    this.link = url;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSecretCode() {
    return secretCode;
  }

  public void setSecretCode(String secretCode) {
    this.secretCode = secretCode;
  }

  public Integer getHitCount() {
    return hitCount;
  }

  public void setHitCount(Integer hitCount) {
    this.hitCount = hitCount;
  }
}
