package Comparator;

import person.Person;

import java.util.Comparator;

/**
 * Comparator class for comparing people in the repository by last name
 */
public class PersonNameComparator implements Comparator<Person> {

    /**
     * method of comparing two people
     * @param obj1 - first person
     * @param obj2 - second person
     * @return  1 - name obj1 > name obj2
     *          0 - name obj1 = name obj2
     *         -1 - name obj1 < name obj2
     */
    @Override
    public int compare(Person obj1, Person obj2)
    {
        return obj1.getName().compareTo(obj2.getName());
    }
}
