package Comparator;

import org.apache.log4j.Logger;
import person.Person;

import java.util.Comparator;

/**
 * Comparator class for comparing people in the repository by Local Date
 */
public class PersonlDateComparator  implements Comparator<Person> {

    private static final Logger logger = Logger.getLogger(Comparator.class);
    /**
     * method of comparing two people
     * @param obj1 - first person
     * @param obj2 - second person
     * @return  1 - lDate obj1 > lDate obj2
     *          0 - lDate obj1 = lDate obj2
     *         -1 - lDate obj1 < lDate obj2
     */
    @Override
    public int compare(Person obj1, Person obj2)
    {
        logger.debug("method compare on date invoked with params: " + obj1 + "and " + obj2);
        return obj1.getBirthday().compareTo(obj2.getBirthday());
    }

}
