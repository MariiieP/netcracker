package sorter;

import person.Person;
import repository.MyArrayList;

import java.util.Comparator;

/**
 * interface ISorter to sort for people in repositories
 */
public interface ISorter {

    /**
     * method to sort for people in repositories
     * @param arr repositories which we sort
     * @param sorter -Comparator<Person> by which we sort
     */
    void sort(MyArrayList arr, Comparator<Person> sorter);
}
