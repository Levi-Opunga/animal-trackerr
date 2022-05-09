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
 public void testIfItSaves(){
    Sighting sighting = make_sighting();
    dao.save(sighting);
    assertEquals(true,sighting.equals(dao.getById(sighting.getId())));
}

    public Sighting make_sighting(){
        return new Sighting(2,"lion", (float) 7.78, (float) 5.77);
    }

}