package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EndangeredAnimal {
    public int id;
    public String name;
    public String healthStatus;
    public String age;
    public String gender;
    public final static List<String> HEALTH_STATUS = List.of("In good Health condition","In need of Urgent Veterinary care","Not in a bad shape can survive");
    public final static List<String> AGE_STATUS = List.of("Newborn","Young","Adult","Very Old");
    public final static List<String> GENDER_CHOICE = List.of("Male","Female");

    public EndangeredAnimal(int id, String name, String healthStatus, String age, String gender) {
        this.id = id;
        this.name = name;
        this.healthStatus = healthStatus;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndangeredAnimal that = (EndangeredAnimal) o;
        return id == that.id && name.equals(that.name) && healthStatus.equals(that.healthStatus) && age.equals(that.age) && gender.equals(that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, healthStatus, age, gender);
    }



}
