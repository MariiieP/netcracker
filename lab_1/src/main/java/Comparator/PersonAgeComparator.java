package Comparator;

import person.Person;

import java.util.Comparator;

/**
 * Comparator class for comparing people in the repository by age
 */
public class PersonAgeComparator implements Comparator<Person> {

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
        return Integer.compare(obj1.getAge(), obj2.getAge());
    }
}
