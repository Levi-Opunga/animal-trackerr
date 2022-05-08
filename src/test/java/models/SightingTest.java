package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {
@Test
    public void ifSightingIscorrectlyInstanciated() {
    Sighting sighting = new Sighting(2,"lion", (float) 7.78, (float) 5.77);
    assertEquals(true,sighting instanceof Sighting);
}

}