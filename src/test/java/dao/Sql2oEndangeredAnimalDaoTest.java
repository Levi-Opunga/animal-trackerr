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
    @Test
    public void test_if_it_deletes_an_endangeredAnimalById(){
        EndangeredAnimal endangeredAnimal = make_animal();
        dao.save(endangeredAnimal);
        dao.deleteById(endangeredAnimal.id);
        assertEquals(0,dao.getAll().size());
    }
    @Test
    public void  testIfItDeletesAll(){
        EndangeredAnimal endangeredAnimal = make_animal();
        EndangeredAnimal endangeredAnimal1 = make_animal();
        EndangeredAnimal endangeredAnimal2 = make_animal();
        dao.save(endangeredAnimal);
        dao.save(endangeredAnimal1);
        dao.save(endangeredAnimal2);
        dao.deleteAll();
        assertEquals(0,dao.getAll().size());
    }
    @Test
    public  void testIfItUpdates(){
        EndangeredAnimal endangeredAnimal = make_animal();
        dao.save(endangeredAnimal);
        endangeredAnimal.setName("dodo bird");
        dao.update(endangeredAnimal);
        assertEquals(endangeredAnimal,dao.getById(endangeredAnimal.getId()));

    }


    public EndangeredAnimal make_animal(){
        return new EndangeredAnimal("White Tiger","sick","old", "male");
    }

}