import com.google.common.collect.Multimap;
import dao.*;
import models.Animal;
import models.EndangeredAnimal;
import models.Sighting;
import spark.staticfiles.StaticFilesFolder;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
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
//  /animal-form/{{id}}
        // /delete-endangered/{{id}}

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

        get("/sighting/:id",(request, response) -> {
            int id = Integer.parseInt(request.params(":id"));
            boolean position = true;
            Map<String,Object> model =new HashMap<String,Object>();
            Boolean update = true;
           Sighting sighting = sightingDao.getById(id);
            model.put("animal",sighting);
            model.put("update",update);
            model.put("position",position);
            return modelAndView(model,"animal-form.hbs");
        },new HandlebarsTemplateEngine());

        post("sighting-update/:id",(request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
            int id = Integer.parseInt(request.params(":id"));
            Animal animal = animalDao.getById(id);
            String animalName = request.queryParams("animal-name");
            animal.setName(animalName);
            animalDao.update(animal);
            response.redirect("/animals");
        return null;
        }, new HandlebarsTemplateEngine());



        // get sighting form
        get("/sighting-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<String> animalTypes = Sighting.ANIMAL_TYPES;
            model.put("animalTypes", animalTypes);
            return modelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        //
        get("/animal-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return modelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangered-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<String> ages = EndangeredAnimal.AGE_STATUS;
            List<String> genders = EndangeredAnimal.GENDER_CHOICE;
            List<String> healthStatuses = EndangeredAnimal.HEALTH_STATUS;
            model.put("ages", ages);
            model.put("genders", genders);
            model.put("healthStatuses", healthStatuses);
            return modelAndView(model, "EndangeredAnimal-form.hbs");
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
            System.out.println(healthStatus + age + gender + name);
            EndangeredAnimal anim = new EndangeredAnimal("White Tiger", "sick", "old", "male");
            EndangeredAnimal endangeredAnimal = new EndangeredAnimal(name, healthStatus, age, gender);
            endangeredAnimalDao.save(anim);
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
            model.put("endangered", sightings);
            return modelAndView(model, "endangeredAnimals.hbs");
        }, new HandlebarsTemplateEngine());











    }




}
