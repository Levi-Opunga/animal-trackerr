package dao;

import java.util.List;

import models.EndangeredAnimal;
import models.Sighting;
import org.sql2o.*;


public class Sql2oSightingDao implements SightingDao {

    @Override
    public void save(Sighting sighting) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sighting (animal_id,animal_type,longitude,latitude,record_date) values (:animal_id,:animal_type,:longitude,:latitude,now())";
            int id = (int) con.createQuery(sql, true)
                    .addParameter("animal_type", sighting.getAnimal_Type())
                    .addParameter("longitude", sighting.getLongitude())
                    .addParameter("latitude", sighting.getLatitude())
                    .addParameter("animal_id", sighting.getAnimal_Id())
                    .executeUpdate()
                    .getKey();
            sighting.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public Sighting getById(int id) {
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM sighting WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
        }
    }

    @Override
    public List<Sighting> getAll() {
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM sighting")
                    .executeAndFetch(Sighting.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from sighting  WHERE id=:id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteAll() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "TRUNCATE TABLE sighting";
            con.createQuery(sql).executeUpdate();
        }

    }

    @Override
    public void update(Sighting sighting) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "Update sighting (animal_id,animal_type,longitude,latitude,record_date) = (:animal_id,:animal_type,:longitude,:latitude,now()) where id=:id";
            con.createQuery(sql, true)
                    .addParameter("animal_type", sighting.getAnimal_Type())
                    .addParameter("longitude", sighting.getLongitude())
                    .addParameter("latitude", sighting.getLatitude())
                    .addParameter("animal_id", sighting.getAnimal_Id())
                    .addParameter("id", sighting.getId())
                    .executeUpdate();
        }
    }
}