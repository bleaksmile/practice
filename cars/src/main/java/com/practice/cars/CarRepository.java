package com.practice.cars;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, String> {
  List<Car> findByPlateContains(String plate);
  List<Car> findByPlateStartsWith(String plate);
  List<Car> findByBrandContains(String car_brand);
}
