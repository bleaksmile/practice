package com.practice.cars;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
  @Id
  private String plate;
  @Column(name="car_brand")
  private String brand;
  private String car_model;
  private String color;
  private Integer year;

  public Car() {
  }

  public Car(String plate, String car_brand, String car_model, String color, Integer year) {
    this.plate = plate;
    this.brand = car_brand;
    this.car_model = car_model;
    this.color = color;
    this.year = year;
  }

  public String getPlate() {
    return plate;
  }

  public void setPlate(String plate) {
    this.plate = plate;
  }

  public String getCar_brand() {
    return brand;
  }

  public void setCar_brand(String car_brand) {
    this.brand = car_brand;
  }

  public String getCar_model() {
    return car_model;
  }

  public void setCar_model(String car_model) {
    this.car_model= car_model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }
}
