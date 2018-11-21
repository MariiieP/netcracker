package Checkers;

import person.Person;

public class PersonlDateCheck implements Checker {
    @Override
    public boolean check(Person findPerson, Object obj) {
        return findPerson.getBirthday().equals(obj);
    }

}
