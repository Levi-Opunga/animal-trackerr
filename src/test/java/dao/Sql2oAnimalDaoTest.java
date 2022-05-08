package dao;

import models.Animal;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sql2oAnimalDaoTest {
    @Test
    public void testIfITsaves() throws Exception {
        Animal animal = new Animal("Goat");
        Sql2oAnimalDao dao = new Sql2oAnimalDao();
        dao.save(animal);
        assertEquals(true,animal.equals(dao.getAnimalById(animal.getId())));
    }



}