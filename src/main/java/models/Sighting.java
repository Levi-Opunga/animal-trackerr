package models;

import java.util.HashMap;
import java.util.Map;

public class Sighting {
  public int AnimalId;
  public String AnimalType;
  public Map<String,Float> AnimalLocation= new HashMap<>();

  public Sighting(int animalId, String animalType,Float longitude,Float latitude) {
    AnimalId = animalId;
    AnimalType = animalType;
    AnimalLocation.put("longitude",longitude);
    AnimalLocation.put("latitude",latitude);
  }
}
