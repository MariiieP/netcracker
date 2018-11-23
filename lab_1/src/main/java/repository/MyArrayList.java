package repository;

import Checkers.Checker;
import Checkers.PersonAgeCheck;
import Checkers.PersonNameCheck;
import Checkers.PersonlDateCheck;
import person.Person;
import sorter.BubleSorter;
import sorter.ISorter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Сlass MyArrayList - class repository that implements the main logic above the leaf of arrays.
 * Able to add, delete objects, automatically expand the array, do a replacement and search by criterion.
 * There are also overrides methods equals and hash code
 */
public class MyArrayList {

    /**
     * array mas that stores specific objects (people)
     */
    private  Person[] arrayPerson;

    /**
     * field count that stores current size mas
     */
    private int count;

    private ISorter sorter;

    /**
     * full constructor for create object type MyArrayList
     */
    public MyArrayList() {
        arrayPerson = new Person[0];
        count = 0;
        sorter = new BubleSorter();
    }

    /**
     * constructor for create object type MyArrayList
     * @param array
     */
    public MyArrayList(Person[] array) {
        arrayPerson = array;
        count = array.length;
        sorter = new BubleSorter();
    }

    /**
     * current count object in array
     * @return int count
     */
    public int Count() {
        return count;
    }

    /**
     * add object in array
     * @param item object type person
     * @return boolean (true - success, false - abort)
     */
    public boolean add(Person item) {

            if (count == arrayPerson.length )
                resize(arrayPerson.length +10);
            arrayPerson[count] = item;
            count++;
            return true;
    }

    /**
     * increases array size by 10 due to lack of space
     * @param newLength - new length
     * return - void
     */
    private void resize(int newLength) {
        Person[] newArray = new Person[newLength];
        System.arraycopy(arrayPerson, 0, newArray, 0, count);
        arrayPerson = newArray;
    }

    /**
     * removes a person from the repository
     * @param personDelete - object delete
     * @return boolesb (true - success, false - abort)
     */
    public boolean remove(Person personDelete) {
        if (personDelete == null) {
            for (int index = 0; index < count; index++)
                if (arrayPerson[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < count; index++)
                if (personDelete.equals(arrayPerson[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    /**
     * helper method for delete remove object in array mas
     * @param index - number object in array mas
     */
    private void fastRemove(int index) {
//        modCount++;
        int numMoved = count - index - 1;
        if (numMoved > 0)
            System.arraycopy(arrayPerson, index + 1, arrayPerson, index,
                    numMoved);
        arrayPerson[--count] = null;
    }

    /**
     * removes a person from the repository
     * @param index - number object for delete
     */
    public void removeAt(int index) {
        fastRemove(index);
    }

    /**
     * getter object for index in array
     * @param index - int number object in array
     * @return search person
     */
    public Person get(int index) {
        return arrayPerson[index];
    }

    /**
     * setter object in array by index
     * @param index - int number object in array
     * @param p - object who want to put
     */
    public void set(int index, Person p) {
        arrayPerson[index] = p;
    }

    /**
     * helper method for finding an object in the list by criterion
     * @param checker - object Checker
     * @param obj - field param for search
     * @return new array list which contains only those objects that satisfy the search condition
     */
    private  MyArrayList find(Checker checker, Object obj) {
        MyArrayList findPerson = new MyArrayList();
        for (Person p : arrayPerson) {
            if (p != null){
                if (checker.check(p, obj)) {
                    findPerson.add(p);
                }
            }
        }
        return findPerson;
    }

    /**
     * method to search for people by name
     * @param name - field string name
     * @return new array list which contains only those objects that satisfy the search condition
     */
    public MyArrayList findOn(String name) {
        return find(new PersonNameCheck(), name);
    }

    /**
     * method to search for people by birthday
     * @param lDate - field Local Date
     * @return new array list which contains only those objects that satisfy the search condition
     */
    public MyArrayList findOn(LocalDate lDate) {
        return find(new PersonlDateCheck(), lDate);
    }

    /**
     * method to search for people by age
     * @param age - field int age
     * @return new array list which contains only those objects that satisfy the search condition
     */
    public MyArrayList findOn(int age) {
        return find(new PersonAgeCheck(), age);
    }

    /**
     * override method toString. Print all person
     * @return string in console
     */
    @Override
    public String toString() {
        return "MyArrayList{" +
                "arrayPerson=" + Arrays.toString(arrayPerson) +
                '}';
    }

    /**
     * Override method equals
     * @param obj -  object class repository
     * @return boolean (true - equal, false - not equal)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyArrayList that = (MyArrayList) obj;
        return Arrays.equals(arrayPerson, that.arrayPerson);
    }

    /**
     * Override method hash Code
     * @return hash code object
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(arrayPerson);
    }

//    public void sortBy(Comparator<Human> comparator) {
//        sorter.sort(this, comparator);
//
    public void sortBy(Comparator<Person> comparator) {
        sorter.sort(this, comparator);
        }

}
