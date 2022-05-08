package dao;

import models.Animal;
import models.EndangeredAnimal;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sql2oAnimalDaoTest {
    @Test
    public void testIfItSavesAndIfFindByIdWorks() throws Exception {
        Animal animal = make_animal();
        Sql2oAnimalDao dao = new Sql2oAnimalDao();
        dao.save(animal);
        assertEquals(true,animal.equals(dao.getById(animal.getId())));
    }




    public Animal make_animal(){
        return new Animal("Goat");
    }

}