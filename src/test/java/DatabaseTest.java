import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseTest {
    Database db;

    @BeforeEach
    void setUp() {
        db = new Database();

        Superhero super1 = new Superhero(
                "Blanket Lord",
                "Lars Larsen",
                "Har altid et godt tilbud til dig",
                1959,
                9.99);
        Superhero super2 = new Superhero(
                "DJ Blyatman",
                "Stanislav Bodkovich",
                "Russian Hardbass",
                1993,
                420);
        Superhero super3 = new Superhero(
                "Johnny Bravo",
                "John Bravo",
                "Tiltproof",
                1970,
                500);
        Superhero super4 = new Superhero(
                "Bodega Bent",
                "Bent Børge Bumsen",
                "Kan drikke 80 øl på i hvert fald et par timer",
                1954,
                14);
        db.addRandomHero(super1);
        db.addRandomHero(super2);
        db.addRandomHero(super3);
        db.addRandomHero(super4);
    }

    @Test
    void addSuperhero() {
        int expectedValue = db.heroList.size() + 1;

        String mySuperName = "Bob";
        String myCivilName = "Salamanca";
        String mySuperPower = "Yeeting and deleting";
        int myCreationYear = 1969;
        double myPowerLevel = 9000.1;
        Superhero mySuperHero = new Superhero(mySuperName, myCivilName, mySuperPower, myCreationYear, myPowerLevel);

        db.heroList.add(mySuperHero);

        int actualValue = db.heroList.size();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void addMoreSuperheroes() {
        int expectedValue = db.heroList.size() + 2;
        String mySuperName = "Bob";
        String myCivilName = "Salamanca";
        String mySuperPower = "Yeeting and deleting";
        int myCreationYear = 1969;
        double myPowerLevel = 9000.1;
        Superhero mySuperHero = new Superhero(mySuperName, myCivilName, mySuperPower, myCreationYear, myPowerLevel);
        db.heroList.add(mySuperHero);
        db.heroList.add(mySuperHero);
        int actualValue = db.heroList.size();

        assertEquals(expectedValue, actualValue);

    }

    @Test
    void find0SuperheroTest() {
        String test = "sdnsjkfgegreyuibiebwiudbewiu";
        ArrayList<Superhero> result = db.findSuperhero(test);
        int actualSize = result.size();
        int expectedSize = 0;
        assertEquals(expectedSize, actualSize);

    }
    @Test
    void find1SuperheroTest() {
        String test2 = "Bodega";
        ArrayList<Superhero> result = db.findSuperhero(test2);
        int actualSize = result.size();
        int expectedSize = 1;
        assertEquals(expectedSize, actualSize);
    }
    @Test
    void findMoreSuperheroTest() {
        String test2 = "B";
        ArrayList<Superhero> result = db.findSuperhero(test2);
        int actualSize = result.size();
        int expectedSize = 4;
        assertEquals(expectedSize, actualSize);
    }
    @Test
    void deleteSuperhero() {
        int test =1;
        int expectedValue = db.heroList.size()-1;
        db.heroList.remove(test);
        int actualValue = db.heroList.size();
        assertEquals(expectedValue,actualValue);
    }
}