package dao;

import org.sql2o.Sql2o;

public class DB {
   //public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-54-158-247-210.compute-1.amazonaws.com:5432/d3e455r1g1fqsc", "bxtkqsvvxodpud", "b7a7c69ee0ff31eadc8580fd3c485b9e61cf8b4a9b80b7c145fd8a552cec1f59");
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/animal_tracker", "login", "123456");
}

//postgresql://localhost:5432/animal_tracker