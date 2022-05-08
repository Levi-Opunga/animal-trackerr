package dao;

import models.Sighting;

import java.util.List;

public interface SightingDao{
    //create
    public void save(Sighting animal);
    //read
    public Sighting getAnimalById(int id);
    public List<Sighting> getAllAnimals();

    //Delete
    public Sighting deleteAnimalById(int id);
    public void deleteAll();

 }