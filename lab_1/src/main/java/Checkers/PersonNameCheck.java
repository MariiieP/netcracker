package Checkers;

import person.Person;

public class PersonNameCheck implements Checker {
    @Override
    public boolean check(Person findPerson, Object obj) {
        return findPerson.getName().equals(obj);
    }
}
