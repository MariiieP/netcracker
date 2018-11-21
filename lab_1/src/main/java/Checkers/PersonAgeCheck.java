package Checkers;

import person.Person;

public class PersonAgeCheck implements Checker {

    @Override
    public boolean check(Person findPerson, Object obj) {
        return Integer.valueOf(findPerson.getAge()).equals(obj);
    }

}
