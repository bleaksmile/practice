package com.tourist.tourist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TouristApplication implements CommandLineRunner {

  @Autowired
  AttractionRepository attractionRepository;

  public static void main(String[] args) {
    SpringApplication.run(TouristApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    attractionRepository.save(new Attraction("Pulitzer","Budapest", 1200,47.4841,19.0602, "restaurant",60, 3));
    attractionRepository.save(new Attraction("Heroes' Square","Budapest", 0,47.4841,19.0601, "park",30, 3));
    attractionRepository.save(new Attraction("House of Terror","Budapest", 3000,47.4841,19.0602, "museum",120, 3));
    attractionRepository.save(new Attraction("PuliOco","Budapest", 12,47.4841,19.0602, "restaurant",60, 3));

  }
}

