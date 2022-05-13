package dao;

import models.EndangeredAnimal;
import models.Sighting;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sql2oSightingDaoTest {

Sql2oSightingDao dao = new Sql2oSightingDao();
    @Rule
    public DatabaseRule databaseRule =new DatabaseRule();
@Test
 public void testIfItSavesAndGetsById(){
    Sighting sighting = make_sighting();
    dao.save(sighting);
    assertEquals(true,sighting.equals(dao.getById(sighting.getId())));
}
@Test
public void testIfItDeletesAll(){
    Sighting sighting= make_sighting();
    Sighting sighting1 = make_sighting();
    Sighting sighting2 = make_sighting();
    dao.save(sighting);
    dao.save(sighting1);
    dao.save(sighting2);
    assertEquals(3,dao.getAll().size());
    dao.deleteAll();
    assertEquals(0,dao.getAll().size());
}

@Test
public void testIfItDeletesById(){
    Sighting sighting = make_sighting();
    dao.save(sighting);
    dao.deleteById(sighting.getId());
    assertEquals(0,dao.getAll().size());
}

@Test
public void testIfItUpdates(){
    Sighting sighting = make_sighting();
    dao.save(sighting);
    sighting.setAnimalType("NEW ANIMAL");
    dao.update(sighting);
    assertEquals(sighting,dao.getById(sighting.getId()));
}




    public Sighting make_sighting(){
        return new Sighting(2,"lion", (float) 7.78, (float) 5.77);
    }

}