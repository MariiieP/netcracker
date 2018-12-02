package Comparator;

import org.apache.log4j.Logger;
import person.Person;

import java.util.Comparator;

/**
 * Comparator class for comparing people in the repository by age
 */
public class PersonAgeComparator implements Comparator<Person> {

    private static final Logger logger = Logger.getLogger(Comparator.class);
    /**
     * method of comparing two people
     * @param obj1 - first person
     * @param obj2 - second person
     * @return  1 - age obj1 > age obj2
     *          0 - age obj1 = age obj2
     *         -1 - age obj1 < age obj2
     */
    @Override
    public int compare(Person obj1, Person obj2)
    {
        logger.debug("method compare on age invoked with params: " + obj1 + "and " + obj2);
        return Integer.compare(obj1.getAge(), obj2.getAge());

    }
}
