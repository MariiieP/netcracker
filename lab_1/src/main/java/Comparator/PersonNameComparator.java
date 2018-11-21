package Comparator;

import person.Person;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person obj1, Person obj2)
    {
        return obj1.getName().compareTo(obj2.getName());
    }
}
