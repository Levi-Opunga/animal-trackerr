package dao;

import models.EndangeredAnimal;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sql2oEndangeredAnimalDaoTest {
    Sql2oEndangeredAnimalDao dao= new Sql2oEndangeredAnimalDao();
    @Rule
   public DatabaseRule databaseRule =new DatabaseRule();
    @Test
    public void TestIfItSaves() throws Exception {
        EndangeredAnimal animal = make_animal();
        dao.save(animal);
        assertEquals(true,animal.equals(dao.getById(animal.getId())));

    }


    public EndangeredAnimal make_animal(){
        return new EndangeredAnimal("White Tiger","sick","old", "male");
    }

}