package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

    @Test
    public void testIfNewEndangeredAnimalISAnInstanceOfEndangeredAnimal(){
        EndangeredAnimal Animal = make_animal();

        assertEquals(true, Animal instanceof EndangeredAnimal);
    }



    public EndangeredAnimal make_animal(){
        return new EndangeredAnimal("White Tiger", EndangeredAnimal.HEALTH_STATUS[1],EndangeredAnimal.AGE_STATUS[1], EndangeredAnimal.GENDER_CHOICE[1]);
    }

}