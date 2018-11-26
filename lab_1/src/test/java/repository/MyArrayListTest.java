package repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import person.Person;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class MyArrayListTest {

    private static MyArrayList rep;

    @Before
    public void setUp() throws Exception {
        rep = new MyArrayList();
    }

    @After
    public void tearDown() throws Exception {
        rep = null;
    }

    @Test
    public void count() {
        LocalDate lDate = LocalDate.of(2000, 1, 1);
        Person p = new Person("", "", 1, lDate);
        rep.add(p);
        LocalDate lDate2 = LocalDate.of(2000, 1, 1);
        Person p2 = new Person("sdf", "sdfg", 1, lDate);
        rep.add(p2);

        int actualParam = rep.Count();
        int expected = 2;
        assertEquals(expected, actualParam);

    }

    //???
    @Test
    public void add() {
        LocalDate lDate = LocalDate.of(2000, 1, 1);
        Person p = new Person("", "", 1, lDate);
        rep.add(p);
        LocalDate lDate2 = LocalDate.of(2000, 1, 1);
        Person p2 = new Person("sdf", "sdfg", 1, lDate);
        rep.add(p2);
        rep.remove(p2);

        int actualParam = rep.Count();
        int expected = 1;
        assertEquals(expected, actualParam);

        int actualParamAge = p2.getAge();
        int expectedAge = 18;
        assertEquals(expectedAge, actualParamAge);
    }

    @Test
    public void remove() {
        LocalDate lDate = LocalDate.of(2000, 1, 1);
        Person p = new Person("", "", 1, lDate);
        rep.add(p);
        LocalDate lDate2 = LocalDate.of(2010, 1, 1);
        Person p2 = new Person("sdf", "sdfg", 1, lDate);
        rep.add(p2);
        rep.remove(p2);

        int actualParam = rep.Count();
        int expected = 1;
        assertEquals(expected, actualParam);

        int actualParamAge = p2.getAge();
        int expectedAge = 18;
        assertEquals(expectedAge, actualParamAge);
    }

    @Test
    public void removeAt() {
        LocalDate lDate = LocalDate.of(2000, 1, 1);
        Person p = new Person("", "", 1, lDate);
        rep.add(p);
        LocalDate lDate2 = LocalDate.of(2010, 1, 1);
        Person p2 = new Person("sdf", "sdfg", 1, lDate);
        rep.add(p2);
        rep.removeAt(1);

        int actualParam = rep.Count();
        int expected = 1;
        assertEquals(expected, actualParam);

        int actualParamAge = p2.getAge();
        int expectedAge = 18;
        assertEquals(expectedAge, actualParamAge);
    }

    @Test
    public void get() {
        LocalDate lDate = LocalDate.of(2000, 1, 1);
        Person p = new Person("", "", 1, lDate);
        rep.add(p);

        Person actualParamGet = rep.get(0);
        Person expectedP = p;
        assertEquals(expectedP, actualParamGet);
    }

    //?????
    @Test
    public void set() {
        LocalDate lDate = LocalDate.of(2000, 1, 1);
        Person p = new Person("", "", 1, lDate);
        rep.add(p);
        rep.set(0,p);

        Person actualParamGet = rep.get(0);
        Person expectedP = rep.get(0);;
        assertEquals(expectedP, actualParamGet);
    }

    @Test
    public void findOnName() {
        LocalDate lDate1 = LocalDate.of(2010, 1, 1);
        Person p1 = new Person("sdf", "sdfg", 1, lDate1);
        rep.add(p1);
        LocalDate lDate2 = LocalDate.of(2010, 1, 1);
        Person p2 = new Person("sqqqq", "sdfg", 1, lDate2);
        rep.add(p2);
        LocalDate lDate3 = LocalDate.of(2010, 1, 1);
        Person p3 = new Person("ww", "sdfg", 1, lDate3);
        rep.add(p3);

        System.out.println(rep);
        MyArrayList findRep = rep.findOn("ww");
        System.out.println(findRep);
    }

    @Test
    public void findOnDate() {
        LocalDate lDate1 = LocalDate.of(2010, 1, 1);
        Person p1 = new Person("sdf", "sdfg", 1, lDate1);
        rep.add(p1);
        LocalDate lDate2 = LocalDate.of(2000, 1, 1);
        Person p2 = new Person("sqqqq", "sdfg", 1, lDate2);
        rep.add(p2);
        LocalDate lDate3 = LocalDate.of(2005, 1, 1);
        Person p3 = new Person("ww", "sdfg", 1, lDate3);
        rep.add(p3);

        LocalDate lDateCur = LocalDate.of(2010, 1, 1);
        MyArrayList findRep = rep.findOn(lDateCur);
        System.out.println(findRep);
    }

    @Test
    public void findOnAge() {
        LocalDate lDate1 = LocalDate.of(2010, 1, 1);
        Person p1 = new Person("sdf", "sdfg", 1, lDate1);
        rep.add(p1);
        LocalDate lDate2 = LocalDate.of(2000, 1, 1);
        Person p2 = new Person("sqqqq", "sdfg", 1, lDate2);
        rep.add(p2);
        LocalDate lDate3 = LocalDate.of(2005, 1, 1);
        Person p3 = new Person("ww", "sdfg", 1, lDate3);
        rep.add(p3);

        MyArrayList findRep = rep.findOn(18);
        System.out.println(findRep);
    }
}