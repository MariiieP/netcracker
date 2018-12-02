package sorter;

import org.apache.log4j.Logger;
import person.Person;
import repository.MyArrayList;

import java.util.Comparator;

public class MergeSorter implements ISorter {

    private static final Logger logger = Logger.getLogger(MergeSorter.class);

    /**
     * sort Shella!!!!!!!!!!!
     * @param arr repositories which we sort
     * @param sorter -Comparator<Person> by which we sort
     */
    @Override
    public void sort(MyArrayList arr, Comparator<Person> sorter) {
        logger.debug("method MergeSorter invoke with params: " + arr.toString() + "and " + sorter);
        int j;
        for (int gap = arr.Count() / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.Count(); i++) {
                Person perTmp = arr.get(i);
                for (j = i; j >= gap && sorter.compare(arr.get(j - gap), perTmp) > 0; j -= gap)
//                for (j = i; j >= gap && arr.get(j - gap) > perTmp; j -= gap)
                {
                    arr.set(j, arr.get(j - gap));
//                    numbers[j] = numbers[j - gap];
                }
                arr.set(j, perTmp);
//                numbers[j] = temp;
            }
        }
    }
}
