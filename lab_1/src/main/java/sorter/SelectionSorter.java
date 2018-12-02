package sorter;

import org.apache.log4j.Logger;
import person.Person;
import repository.MyArrayList;

import java.util.Comparator;

public class SelectionSorter implements ISorter{

    private static final Logger logger = Logger.getLogger(BubleSorter.class);

    @Override
    public void sort (MyArrayList arr, Comparator<Person> sorter){
        logger.debug("method SelectionSorter invoke with params: " + arr.toString() + "and " + sorter);
        int min, temp;
        for (int index = 0; index < arr.Count()-1; index++){
            min = index;
            for (int scan = index+1; scan < arr.Count(); scan++){
                    if (sorter.compare(arr.get(scan),arr.get(min)) < 0)
                    min = scan;
            }
            Person perTmp = arr.get(min);
            arr.set(min, arr.get(index));
            arr.set(index,perTmp);
        }
    }


}
