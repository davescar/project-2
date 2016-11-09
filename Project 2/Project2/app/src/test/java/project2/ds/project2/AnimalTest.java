package project2.ds.project2;

/**
 * Created by ds on 11/9/16.
 */

import org.junit.Test;
import static org.junit.Assert.*;
public class AnimalTest {

    @Test
    public void testIfSpeciesIsCorrect() {

        Animal animal = new Animal(0, 0, "Human", null, null, null, 0, null);

        String expected = "Human";
        String actual = animal.getSpecies();

        assertEquals(expected, actual);

    }

    @Test
    public void testIfNameIsCorrect() {

        Animal animal = new Animal(0, 0, null, null, null, null, 0, "Axe");

        String expected = "Axe";
        String actual = animal.getAnimalName();

        assertEquals(expected, actual);

    }

    @Test
    public void testIfLifespanIsCorrect() {

        Animal animal = new Animal(0, 130, null, null, null, null, 0, null);

        int expected = 130;
        int actual = animal.getLifeSpan();

        assertEquals(expected, actual);
    }

}