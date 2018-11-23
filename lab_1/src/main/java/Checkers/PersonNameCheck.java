package Checkers;

import person.Person;

/**
 * PersonAgeCheck class to search for people in
 * repositories for a specific parameter (Name)
 */
public class PersonNameCheck implements Checker {

    /**
     * override method for search person in repository
     * @param findPerson - object type Person who are looking for
     * @param obj - the value of a parameter by which we are looking for it
     * @return boolean - the object matched the search value or not
     */
    @Override
    public boolean check(Person findPerson, Object obj) {
        return findPerson.getName().equals(obj);
    }
}
