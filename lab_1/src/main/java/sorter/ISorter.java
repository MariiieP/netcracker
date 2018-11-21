package sorter;

import java.util.Comparator;

public interface ISorter<T> {

    public void sort(Object[] arr, Comparator<T> sorter);
}
