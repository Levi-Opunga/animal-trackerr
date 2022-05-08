package dao;
 import models.Animal;
 import models.EndangeredAnimal;

 import java.util.List;

public interface EndangeredAnimalDao {
    //create
    public void save(EndangeredAnimal animal);
    //read
    public EndangeredAnimal getById(int id);
    public List<EndangeredAnimal> getAll();

    //Delete
    public EndangeredAnimal deleteAById(int id);
    public void deleteAll();
}