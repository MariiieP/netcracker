package sorter;

import person.Person;
import repository.MyArrayList;

import java.util.Comparator;

public class SelectionSorter implements ISorter{

    @Override
    public void sort (MyArrayList arr, Comparator<Person> sorter){
        int min, temp;
        for (int index = 0; index < arr.Count()-1; index++){
            min = index;
            for (int scan = index+1; scan < arr.Count(); scan++){
                    if (sorter.compare(arr.get(scan),arr.get(min)) < 0)
//                  if (numbers[scan] < numbers[min])
                    min = scan;
            }
            // Swap the values
            Person perTmp = arr.get(min);
            arr.set(min, arr.get(index));
            arr.set(index,perTmp);
        }
    }


}
