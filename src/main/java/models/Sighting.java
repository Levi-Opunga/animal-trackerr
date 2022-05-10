package models;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Sighting {
  public int Animal_Id;
  public String Animal_Type;

  public final static String[] ANIMAL_TYPES = {"Regular Animal","Endangered Animal"};
private Float longitude ;
private Float latitude;
 Timestamp record_date;
    private String date;
    private int id;

  public Sighting(int animalId, String animalType,Float longitude,Float latitude) {
    Animal_Id = animalId;
    Animal_Type = animalType;
   this.longitude = longitude;
   this.latitude = latitude;
  }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
    return Animal_Id;
  }

  public void setAnimalId(int animalId) {
    Animal_Id = animalId;
  }

  public String getAnimalType() {
    return Animal_Type;
  }

  public void setAnimalType(String animalType) {
    Animal_Type = animalType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return Animal_Id == sighting.Animal_Id && id == sighting.id && Animal_Type.equals(sighting.Animal_Type) && longitude.equals(sighting.longitude) && latitude.equals(sighting.latitude);
    }

    public int getAnimal_Id() {
        return Animal_Id;
    }

    public void setAnimal_Id(int animal_Id) {
        Animal_Id = animal_Id;
    }

    public String getAnimal_Type() {
        return Animal_Type;
    }

    public void setAnimal_Type(String animal_Type) {
        Animal_Type = animal_Type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Animal_Id, Animal_Type, longitude, latitude, id);
    }
}
