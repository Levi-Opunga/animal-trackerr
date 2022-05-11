package models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EndangeredAnimal {
    public int id;
    public String name;
    public String health_status;
    public String age;
    public String gender;
    public String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Timestamp record_date;
    public final static String[] HEALTH_STATUS = {"In good Health condition","In need of Urgent Veterinary care","Not in a bad shape can survive"};
    public final static String[] AGE_STATUS = {"Newborn","Young","Adult","Very Old"};
    public final static String[] GENDER_CHOICE = {"Male","Female"};

    public EndangeredAnimal( String name, String healthStatus, String age, String gender) {
        this.name = name;
        this.health_status = healthStatus;
        this.age = age;
        this.gender = gender;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealthStatus() {
        return health_status;
    }

    public void setHealthStatus(String healthStatus) {
        this.health_status = healthStatus;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndangeredAnimal animal = (EndangeredAnimal) o;
        return id == animal.id && name.equals(animal.name) && health_status.equals(animal.health_status) && age.equals(animal.age) && gender.equals(animal.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, health_status, age, gender);
    }

    public String getHealth_status() {
        return health_status;
    }

    public void setHealth_status(String health_status) {
        this.health_status = health_status;
    }

    public Timestamp getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Timestamp record_date) {
        this.record_date = record_date;
    }


}
