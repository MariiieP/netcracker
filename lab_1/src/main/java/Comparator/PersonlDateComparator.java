package Comparator;

import person.Person;

import java.util.Comparator;

public class PersonlDateComparator  implements Comparator<Person> {

    @Override
    public int compare(Person obj1, Person obj2)
    {
        return obj1.getBirthday().compareTo(obj2.getBirthday());
    }

}
