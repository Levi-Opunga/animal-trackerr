package dao;

import models.Animal;

import java.util.List;

public interface AnimalDao {
    //create
    public void save(Animal animal) ;

    //read
    public Animal getById(int id);
    public List<Animal> getAll();

    //Delete
    public void deleteById(int id);
    public void deleteAll();

    public void update(Animal animal);


}