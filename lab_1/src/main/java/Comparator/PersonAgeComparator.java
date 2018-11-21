package Comparator;

import person.Person;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person obj1, Person obj2)
    {
        return Integer.compare(obj1.getAge(), obj2.getAge());
    }
}
