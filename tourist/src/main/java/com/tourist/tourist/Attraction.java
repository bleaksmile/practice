package com.tourist.tourist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attraction {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String city;
  private Integer price;
  private Double longitude;
  private Double latitude;
  private String category;
  private Integer duration;
  private Integer recommendedAge;

  public Attraction() {
  }

  public Attraction(String name, String city, Integer price, Double longitude, Double latitude, String category, Integer duration, Integer recommendedAge) {
    this.name = name;
    this.city = city;
    this.price = price;
    this.longitude = longitude;
    this.latitude = latitude;
    this.category = category;
    this.duration = duration;
    this.recommendedAge = recommendedAge;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public Integer getRecommendedAge() {
    return recommendedAge;
  }

  public void setRecommendedAge(Integer recommendedAge) {
    this.recommendedAge = recommendedAge;
  }
}
