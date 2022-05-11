package dao;

import models.Sighting;

import java.util.List;

public interface SightingDao{
    //create
    public void save(Sighting animal);
    //read
    public Sighting getById(int id);
    public List<Sighting> getAll();

    //Delete
    public void deleteById(int id);
    public void deleteAll();
    public void update(Sighting sighting);

 }