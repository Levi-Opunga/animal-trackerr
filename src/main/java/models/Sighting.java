package models;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Sighting {
  public int AnimalId;
  public String AnimalType;
private Float longitude ;
private Float latitude;
 Timestamp record_date;
 private int id;

  public Sighting(int animalId, String animalType,Float longitude,Float latitude) {
    AnimalId = animalId;
    AnimalType = animalType;
   this.longitude = longitude;
   this.latitude = latitude;
  }

    public Timestamp getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Timestamp record_date) {
        this.record_date = record_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimalId() {
    return AnimalId;
  }

  public void setAnimalId(int animalId) {
    AnimalId = animalId;
  }

  public String getAnimalType() {
    return AnimalType;
  }

  public void setAnimalType(String animalType) {
    AnimalType = animalType;
  }

  public Float getLongitude() {
    return longitude;
  }

  public void setLongitude(Float longitude) {
    this.longitude = longitude;
  }

  public Float getLatitude() {
    return latitude;
  }

  public void setLatitude(Float latitude) {
    this.latitude = latitude;
  }
}
