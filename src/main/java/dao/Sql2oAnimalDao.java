package dao;

import dao.AnimalDao;
import models.Animal;

import java.util.List;

import org.postgresql.util.PSQLException;
import org.sql2o.*;


public class Sql2oAnimalDao implements AnimalDao {

    @Override
    public void save(Animal animal) {
     try (Connection con =DB.sql2o.open()){
     String sql = "INSERT INTO Animal (name, record_date) values (:name, now())";
     int id = (int) con.createQuery(sql,true)
             .addParameter("name",animal.getName())
             .executeUpdate()
             .getKey();
     animal.setId(id);
     } catch (Sql2oException ex) {
         System.out.println(ex); //oops we have an error!
     }

    }

    @Override
    public Animal getById(int id) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM animal WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
        }
    }

    @Override
    public List<Animal> getAll() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM Animal")
                    .executeAndFetch(Animal.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from Animal WHERE id=:id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void deleteAll() {
        try (Connection con = DB.sql2o.open()) {
           String sql = "TRUNCATE TABLE Animal";
           con.createQuery(sql).executeUpdate();
        }

    }

    @Override
    public void update(Animal animal) {
        try (Connection con =DB.sql2o.open()){
            String sql = "Update Animal set (name, record_date) = (:name, now()) where id=:id";
             con.createQuery(sql,true)
                     .addParameter("name",animal.getName())
                    .addParameter("id",animal.getId())
                    .executeUpdate();
        }
    }
}