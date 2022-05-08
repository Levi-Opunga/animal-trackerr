package dao;

import models.Animal;

import java.util.List;

public interface AnimalDao {
    //create
    public void save(Animal animal);
 //read
    public Animal getAnimalById(int id);
    public List<Animal> getAllAnimals();

    //Delete
    public Animal deleteAnimalById(int id);
    public void deleteAll();


}