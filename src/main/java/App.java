import dao.Sql2oAnimalDao;
import dao.Sql2oEndangeredAnimalDao;
import models.Animal;
import models.EndangeredAnimal;
import models.Sighting;
import spark.staticfiles.StaticFilesFolder;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        //creating DAO instances
        Sql2oEndangeredAnimalDao EndangeredAnimalDao = new Sql2oEndangeredAnimalDao();
        Sql2oAnimalDao animalDao = new Sql2oAnimalDao();


        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<String,Object>();
            return modelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sighting-form",(request, response) -> {
            Map<String,Object> model = new HashMap<String,Object>();
            List<String>  animalTypes =  Sighting.ANIMAL_TYPES;
            model.put("animalTypes",animalTypes);
        return modelAndView(model,"sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animal-form",(request, response) -> {
            Map<String,Object> model = new HashMap<String,Object>();
            return modelAndView(model,"animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangered-form",(request, response) -> {
            Map<String,Object> model = new HashMap<String,Object>();
          List<String>  ages =  EndangeredAnimal.AGE_STATUS;
            List<String> genders = EndangeredAnimal.GENDER_CHOICE;
            List<String> healthStatuses = EndangeredAnimal.HEALTH_STATUS;
            model.put("ages",ages);
            model.put("genders",genders);
            model.put("healthStatuses",healthStatuses);
            return modelAndView(model,"EndangeredAnimal-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/success",(request, response) -> {

            Map<String,Object> model = new HashMap<String,Object>();
            return modelAndView(model,"success.hbs");

        },new HandlebarsTemplateEngine());

        post("/animal-post",(request, response) -> {
            Map<String,Object> model = new HashMap<String,Object>();
            String animalName = request.queryParams("animal-name");
            Animal animal = new Animal(animalName);
            animalDao.save(animal);
           response.redirect("/success");
           return null;
        },new HandlebarsTemplateEngine());

        get("/animals",(request, response) -> {
            Map<String,Object> model = new HashMap<String,Object>();
            List<Animal> animals = animalDao.getAll();
            model.put("animals",animals);
            return modelAndView(model,"animals.hbs");
        },new HandlebarsTemplateEngine());














        post("",(request,response) ->{

            return null;
        },new HandlebarsTemplateEngine());


        post("",(request,response) ->{

           return null;
        },new HandlebarsTemplateEngine());

    }



}
