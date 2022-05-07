package models;

import java.util.ArrayList;
import java.util.List;

public class EndangeredAnimal {
    public int id;
    public String name;
    public String healthStatus;
    public int age;
    public String gender;
    public final static List<String> HEALTH_STATUS = List.of("In good Health condition","In need of Urgent Veterinary care","Not in a bad shape can survive");
    public final static List<String> AGE_STATUS = List.of("Newborn","Young","Adult","Very Old");
    public final static List<String> GENDER_CHOICE = List.of("Male","Female");

    public EndangeredAnimal(int id, String name, String healthStatus, int age, String gender) {
        this.id = id;
        this.name = name;
        this.healthStatus = healthStatus;
        this.age = age;
        this.gender = gender;
    }
}
