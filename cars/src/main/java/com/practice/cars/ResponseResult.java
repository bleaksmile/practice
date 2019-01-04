package com.practice.cars;


import java.util.List;

public class ResponseResult {
  private String result;
  private List<Car> data;


  public ResponseResult() {
    this.result="ok";
  }

  public ResponseResult(List<Car> data) {
    this();
    this.data = data;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public List<Car> getData() {
    return data;
  }

  public void setData(List<Car> data) {
    this.data = data;
  }
}
