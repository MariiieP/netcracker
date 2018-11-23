package Comparator;

import person.Person;

import java.util.Comparator;

/**
 * Comparator class for comparing people in the repository by Local Date
 */
public class PersonlDateComparator  implements Comparator<Person> {

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
        return obj1.getBirthday().compareTo(obj2.getBirthday());
    }

}
