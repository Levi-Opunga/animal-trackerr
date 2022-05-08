package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    @Test
    public void ifAnimalIsAnInstanceOfAnimal(){
        Animal animal = new Animal("Goat",1);
        assertEquals(true, animal instanceof Animal);
    }

}