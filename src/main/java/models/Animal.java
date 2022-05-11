package models;

import java.sql.Timestamp;
import java.util.Objects;

public class Animal {
    private String name;
    private int id;
   private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private Timestamp record_date;
    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id && name.equals(animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Timestamp getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Timestamp record_date) {
        this.record_date = record_date;
    }

    public void setId(int id) {
        this.id = id;
    }
}
