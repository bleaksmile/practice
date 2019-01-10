package com.tourist.tourist;

import java.util.ArrayList;
import java.util.List;

public class FilteredAttractions {
  List<Attraction> attractions;

  public FilteredAttractions() {
    this.attractions = new ArrayList<>();
  }

  public FilteredAttractions(List<Attraction> attractions) {
    this.attractions = attractions;
  }

  public List<Attraction> getAttractions() {
    return attractions;
  }

  public void setAttractions(List<Attraction> attractions) {
    this.attractions = attractions;
  }
}
