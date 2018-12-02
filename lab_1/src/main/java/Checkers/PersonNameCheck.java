package Checkers;

import org.apache.log4j.Logger;
import person.Person;

/**
 * PersonAgeCheck class to search for people in
 * repositories for a specific parameter (Name)
 */
public class PersonNameCheck implements Checker {

    private static final Logger logger = Logger.getLogger(Checker.class);
    /**
     * override method for search person in repository
     * @param findPerson - object type Person who are looking for
     * @param obj - the value of a parameter by which we are looking for it
     * @return boolean - the object matched the search value or not
     */
    @Override
    public boolean check(Person findPerson, Object obj)
    {
        logger.debug("method compare on name invoked with params: " + findPerson + "and " + obj);
        return findPerson.getName().equals(obj);
    }
}
