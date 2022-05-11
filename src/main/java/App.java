import com.google.common.collect.Multimap;
import dao.*;
import models.Animal;
import models.EndangeredAnimal;
import models.Sighting;

import spark.template.handlebars.HandlebarsTemplateEngine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        //creating DAO instances
        Sql2oEndangeredAnimalDao endangeredAnimalDao = new Sql2oEndangeredAnimalDao();
        Sql2oAnimalDao animalDao = new Sql2oAnimalDao();
        Sql2oSightingDao sightingDao = new Sql2oSightingDao();

//get homepage
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return modelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        // get sighting form
        get("/sightingform", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String[] animalTypes = Sighting.ANIMAL_TYPES;
            model.put("animalTypes", animalTypes);
            return modelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        //
        get("/animal-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return modelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangeredform", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String[] ages = EndangeredAnimal.AGE_STATUS;
            String[] genders = EndangeredAnimal.GENDER_CHOICE;
            String[] healthStatuses = EndangeredAnimal.HEALTH_STATUS;
            model.put("ages", ages);
            model.put("genders", genders);
            model.put("healthStatuses", healthStatuses);
            return modelAndView(model, "EndangeredAnimal-form.hbs");
        }, new HandlebarsTemplateEngine());


        /// Delete individual
        get("/delete-sighting/:id",(request, response)->{
            int id = Integer.parseInt(request.params(":id"));
            sightingDao.deleteById(id);
            response.redirect("/sightings");
            return null;
        },new HandlebarsTemplateEngine());

        get("/delete-endangered/:id",(request, response)->{
            int id = Integer.parseInt(request.params(":id"));
            sightingDao.deleteById(id);
            response.redirect("/endangered-animals");
            return null;
        },new HandlebarsTemplateEngine());

        get("/delete-animal/:id",(request, response)->{
            int id = Integer.parseInt(request.params(":id"));
            animalDao.deleteById(id);
            response.redirect("/animals");
            return null;
        },new HandlebarsTemplateEngine());






//delete  all

        get("/delete-all-sightings", (request, response) -> {
            sightingDao.deleteAll();
            response.redirect("/sightings");
           return null;
        },new HandlebarsTemplateEngine());

        get("/delete-all-endangeredAnimals", (request, response) -> {
            endangeredAnimalDao.deleteAll();
            response.redirect("/endangered-animals");
            return null;
        },new HandlebarsTemplateEngine());

        get("/delete-all-animals", (request, response) -> {
            animalDao.deleteAll();
            response.redirect("/animals");
            return null;
        },new HandlebarsTemplateEngine());
//  /animal update ////////////////////////////////////////////

        get("animal/:id",(request, response) -> {
            int id = Integer.parseInt(request.params(":id"));
            boolean position = true;
            Map<String,Object> model =new HashMap<String,Object>();
            Boolean update = true;
            Animal animal = animalDao.getById(id);
            model.put("animal",animal);
            model.put("update",update);
            model.put("position",position);
            return modelAndView(model,"animal-form.hbs");
        },new HandlebarsTemplateEngine());


        post("animal-update/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int id = Integer.parseInt(request.params(":id"));
            Animal animal = animalDao.getById(id);
            String animalName = request.queryParams("animal-name");
            animal.setName(animalName);
            animalDao.update(animal);
            response.redirect("/animals");
            return null;
        }, new HandlebarsTemplateEngine());



//// sightings update ///////////////////////////////////////////////
        get("/sighting/:id",(request, response) -> {
            int id = Integer.parseInt(request.params(":id"));
            boolean position = true;
            Map<String,Object> model =new HashMap<String,Object>();
            Boolean update = true;
           Sighting sighting = sightingDao.getById(id);
            String[] animalTypes = Sighting.ANIMAL_TYPES;
            model.put("animalTypes", animalTypes);
            model.put("sighting",sighting);
            model.put("update",update);
            model.put("position",position);
            return modelAndView(model,"sighting-form.hbs");
        },new HandlebarsTemplateEngine());

        post("sighting-update/:id",(request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
            int id = Integer.parseInt(request.params(":id"));
            Sighting sighting = sightingDao.getById(id);
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            String animalType = request.queryParams("animalType");
            Float latitude = Float.valueOf(request.queryParams("latitude"));
            Float longitude = Float.valueOf(request.queryParams("longitude"));
            sighting.setAnimalType(animalType);
            sighting.setLatitude(latitude);
            sighting.setLongitude(longitude);
            sighting.setAnimal_Id(animalId);
            sightingDao.update(sighting);
            response.redirect("/sightings");
        return null;
        }, new HandlebarsTemplateEngine());
//// endangered animal update
        get("/endangered/:id",(request, response) -> {
            int id = Integer.parseInt(request.params(":id"));
            boolean position = true;
            Map<String,Object> model =new HashMap<String,Object>();
            Boolean update = true;
            EndangeredAnimal endangered = endangeredAnimalDao.getById(id);
            String[] ages = EndangeredAnimal.AGE_STATUS;
            String[] genders = EndangeredAnimal.GENDER_CHOICE;
            String[] healthStatuses = EndangeredAnimal.HEALTH_STATUS;
            model.put("position",position);
            model.put("ages", ages);
            model.put("genders", genders);
            model.put("healthStatuses", healthStatuses);
            model.put("update",update);
            model.put("endangered",endangered);
            return modelAndView(model,"EndangeredAnimal-form.hbs");
        },new HandlebarsTemplateEngine());


        post("endangered-update/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int id = Integer.parseInt(request.params(":id"));
            EndangeredAnimal endangered = endangeredAnimalDao.getById(id);
            String name = request.queryParams("name");
            String gender = request.queryParams("gender");
            String age = request.queryParams("age");
            String healthStatus = request.queryParams("healthStatus");
            endangered.setName(name);
            endangered.setGender(gender);
            endangered.setHealth_status(healthStatus);
            endangered.setAge(age);
            endangeredAnimalDao.update(endangered);
            response.redirect("/endangered-animals");
            return null;
        }, new HandlebarsTemplateEngine());


        get("/success", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return modelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/animal-post", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String animalName = request.queryParams("animal-name");
            Animal animal = new Animal(animalName);
            animalDao.save(animal);
            response.redirect("/success");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Animal> animals = animalDao.getAll();
            for (Animal animal: animals){
                animal.setDate(DateFormat.getDateTimeInstance().format(animal.getRecord_date()));
            }
            model.put("animals", animals);
            return modelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());


        post("/post-sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            String animalType = request.queryParams("animalType");
            Float latitude = Float.valueOf(request.queryParams("latitude"));
            Float longitude = Float.valueOf(request.queryParams("longitude"));
            Sighting sighting = new Sighting(animalId, animalType, longitude, latitude);
            sightingDao.save(sighting);
            response.redirect("/success");
            return null;
        }, new HandlebarsTemplateEngine());


        post("/post-endangered", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String gender = request.queryParams("gender");
            String age = request.queryParams("age");
            String healthStatus = request.queryParams("healthStatus");
            EndangeredAnimal endangeredAnimal = new EndangeredAnimal(name, healthStatus, age, gender);
            endangeredAnimalDao.save(endangeredAnimal);
            response.redirect("/success");
            return null;
        }, new HandlebarsTemplateEngine());


        get("/endangered-animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<EndangeredAnimal> endangeredAnimal = endangeredAnimalDao.getAll();
            for (EndangeredAnimal animal :endangeredAnimal){
               animal.setDate(DateFormat.getDateTimeInstance().format(animal.record_date));
            }
            model.put("endangered", endangeredAnimal);
            return modelAndView(model, "endangeredAnimals.hbs");
        }, new HandlebarsTemplateEngine());


        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Sighting> sightings = sightingDao.getAll();
            for (Sighting sighting : sightings){
                sighting.setDate(DateFormat.getDateTimeInstance().format(sighting.getRecord_date()));
            }
            model.put("sighting", sightings);
            return modelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());











    }




}
