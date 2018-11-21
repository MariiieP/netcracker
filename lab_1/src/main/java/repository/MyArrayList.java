package repository;

import Checkers.Checker;
import Checkers.PersonAgeCheck;
import Checkers.PersonNameCheck;
import Checkers.PersonlDateCheck;
import person.Person;

import java.time.LocalDate;
import java.util.Arrays;

public class MyArrayList {

    private  Person[] arrayPerson;
    private int count;

    public MyArrayList() {
        arrayPerson = new Person[0];
        count = 0;
//        sorter = new ShellSorter();
    }

    public MyArrayList(Person[] array) {
        arrayPerson = array;
        count = array.length;
//        sorter = new ShellSorter();
    }

    public int Count() {
        return count;
    }

    public boolean add(Person item) {

            if (count == arrayPerson.length )
                resize(arrayPerson.length +10);
            arrayPerson[count] = item;
            count++;
            return true;
    }

    private void resize(int newLength) {
        Person[] newArray = new Person[newLength];
        System.arraycopy(arrayPerson, 0, newArray, 0, count);
        arrayPerson = newArray;
    }

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

    private void fastRemove(int index) {
//        modCount++;
        int numMoved = count - index - 1;
        if (numMoved > 0)
            System.arraycopy(arrayPerson, index + 1, arrayPerson, index,
                    numMoved);
        arrayPerson[--count] = null;
    }

    public void removeAt(int index) {
        fastRemove(index);
    }

    public Person get(int index) {
        return arrayPerson[index];
    }


    public void set(int index, Person human) {
        arrayPerson[index] = human;
    }

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

    public MyArrayList findOn(String name) {
        return find(new PersonNameCheck(), name);
    }

    public MyArrayList findOn(LocalDate lDate) {
        return find(new PersonlDateCheck(), lDate);
    }

    public MyArrayList findOn(int age) {
        return find(new PersonAgeCheck(), age);
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "arrayPerson=" + Arrays.toString(arrayPerson) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyArrayList that = (MyArrayList) obj;
        return Arrays.equals(arrayPerson, that.arrayPerson);
    }


    @Override
    public int hashCode() {
        return Arrays.hashCode(arrayPerson);
    }


}
