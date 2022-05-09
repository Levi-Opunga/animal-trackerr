package dao;

import dao.DB;


import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/animal_tracker_test", "login", "123456");
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deletePersonsQuery = "DELETE FROM sighting *;";
            String deleteMonstersQuery = "DELETE FROM animal *;";
            String deleteCommunitiesQuery = "DELETE FROM endangeredanimal *;";


            con.createQuery(deletePersonsQuery).executeUpdate();
            con.createQuery(deleteMonstersQuery).executeUpdate();
            con.createQuery(deleteCommunitiesQuery).executeUpdate();


        }
    }


}