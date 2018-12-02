package person;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PersonTest {

    private static Person p;


    @Before
    public void setUp() throws Exception {
        LocalDate lDate = LocalDate.of(2000, 1, 1);
        p = new Person("ann","volodina",1,lDate);
    }

    @After
    public void tearDown() throws Exception {
        p = null;
    }

    @Test
    public void getId() {
        int actualParam = p.getId();
//        int expected = 1;
        int expected = 5;
        assertEquals(expected, actualParam);
    }

    @Test
    public void getName() {
        String actualParam = p.getName();
        String expected = "ann";
        assertEquals(expected, actualParam);
    }

    @Test
    public void getSurName() {
        String actualParam = p.getSurName();
        String expected = "volodina";
        assertEquals(expected, actualParam);
    }

    @Test
    public void getBirthday() {
        LocalDate actualParam = p.getBirthday();
        LocalDate expected = LocalDate.of(2000, 1, 1);
        assertEquals(expected, actualParam);
    }

    @Test
    public void getAge() {
        int actualParam = p.getAge();
        int expected = 18;
        assertEquals(expected, actualParam);
    }

    @Test
    public void getGender() {
        String actualParam = p.toGender();
        String expected = "Пол \"Женский\"";
        assertEquals(expected, actualParam);
    }
}