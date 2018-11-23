package sorter;

import person.Person;
import repository.MyArrayList;

import java.util.Comparator;

public class BubleSorter implements ISorter {

    @Override
    public void sort(MyArrayList arr, Comparator<Person> sorter) {
        for (int i = arr.Count()-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sorter.compare(arr.get(j), arr.get(j + 1)) > 0) {
                    if (j != j + 1) {
                        // Swap the values
                        Person perTmp = arr.get(j);
                        arr.set(j, arr.get(j + 1));
                        arr.set(j+1,perTmp);
                    }
                }
            }
        }
    }
}