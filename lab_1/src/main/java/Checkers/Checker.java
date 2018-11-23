package Checkers;

import person.Person;

/**
 * interface Checker to search for people in
 * repositories for a specific parameter
 * @see PersonAgeCheck
 * @see PersonlDateCheck
 * @see PersonNameCheck
 */
public interface Checker {

    /**
     * method for search person in repository
     * @param p - object type Person who are looking for
     * @param obj - the value of a parameter by which we are looking for it
     * @return boolean - the object matched the search value or not
     */
    boolean check(Person p, Object obj);

}
