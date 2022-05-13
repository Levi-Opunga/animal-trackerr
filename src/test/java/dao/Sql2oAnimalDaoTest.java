package dao;

import models.Animal;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sql2oAnimalDaoTest {
    Sql2oAnimalDao dao = new Sql2oAnimalDao();
  @Rule
  public DatabaseRule databaseRule =new DatabaseRule();
    @Test
    public void testIfItSavesAndIfFindByIdWorks() throws Exception {
        Animal animal = make_animal();
        dao.save(animal);
        assertEquals(true,animal.equals(dao.getById(animal.getId())));
    }
    @Test
    public void test_if_it_deletes_an_animalById(){
        Animal animal = make_animal();
        dao.save(animal);
        dao.deleteById(animal.getId());
        assertEquals(0,dao.getAll().size());
    }
    @Test
    public void testIfItDeletesAll(){
        Animal animal = make_animal();
        Animal animal1 = make_animal();
        Animal animal2 = make_animal();
        dao.save(animal);
        dao.save(animal1);
        dao.save(animal2);
        dao.deleteAll();
        assertEquals(0,dao.getAll().size());
    }
@Test
public void TestIfItSaveUpdatesAnimal(){
        Animal animal = make_animal();
        dao.save(animal);
        animal.setName("Koala");
        dao.update(animal);
        assertEquals(animal, dao.getById(animal.getId()));
}



    public Animal make_animal(){
        return new Animal("Goat");
    }

}