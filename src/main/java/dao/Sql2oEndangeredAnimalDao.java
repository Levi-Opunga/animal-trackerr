package dao;

import java.util.List;

import models.EndangeredAnimal;
import org.sql2o.*;


public class Sql2oEndangeredAnimalDao implements EndangeredAnimalDao {

    @Override
    public void save(EndangeredAnimal animal) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO endangeredanimal (name ,health_status ,age ,gender ,record_date) values (:name,:health_status,:age, :gender ,now())";
            int id = (int) con.createQuery(sql, true)
                    .addParameter("name", animal.getName())
                    .addParameter("health_status", animal.getHealthStatus())
                    .addParameter("age", animal.getAge())
                    .addParameter("gender", animal.getGender())
                    .executeUpdate()
                    .getKey();
            animal.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!
        }

    }

    @Override
    public EndangeredAnimal getById(int id) {
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM endangeredanimal WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
        }
    }

    @Override
    public List<EndangeredAnimal> getAll() {
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM endangeredanimal")
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from endangeredanimal  WHERE id=:id";
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
            String sql = "TRUNCATE TABLE endangeredanimal";
            con.createQuery(sql).executeUpdate();
        }

    }

    @Override
    public void update(EndangeredAnimal animal) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "UPDATE endangeredanimal SET (name ,health_status ,age ,gender ,record_date) = (:name,:health_status,:age, :gender ,now()) WHERE id=:id";
            con.createQuery(sql, true)
                    .addParameter("name", animal.getName())
                    .addParameter("health_status", animal.getHealthStatus())
                    .addParameter("age", animal.getAge())
                    .addParameter("gender", animal.getGender())
                    .addParameter("id", animal.getId())
                    .executeUpdate();

        }
    }
}