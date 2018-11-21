package sorter;

import java.util.Comparator;

//import person.Person;
//import person.Person;

public class BubleSorter<T> implements ISorter<T> {
    @Override
    public void sort(Object[] arr, Comparator<T> sorter) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[j + 1]) {
//                    Swap(arr,j,j+1);
                    if (j != j + 1) {
                        Object perTmp = arr[j];
//            MyArrayList tmp

                        arr[j] = arr[j + 1];
                        arr[j + 1] = perTmp;
                    }
                }
            }
        }

//    public void bubbleSort(MyArrayList<Person> arr){
////    Внешний цикл каждый раз сокращает фрагмент массива,
////      так как внутренний цикл каждый раз ставит в конец
////      фрагмента максимальный элемент
//        for(int i = arr.size()-1 ; i > 0 ; i--){
//            for(int j = 0 ; j < i ; j++){
////            Сравниваем элементы попарно,
////              если они имеют неправильный порядок,
////              то меняем местами
//                if( arr.get(j).compareTo(arr.get(j+1)) == 1 ){
//                    Swap(arr,j,j+1);
////                int tmp = arr[j];
////                arr[j] = arr[j+1];
////                arr[j+1] = tmp;
//                }
//            }
//        }
//    }

//
//    public void Swap(Object[] arr, int left, int right)
//    {
//        if (left != right)
//        {
//            Person perTmp= arr[left];
////            MyArrayList tmp
//
//            arr[left] = arr[right];
//            arr[right] = perTmp;
//        }
//    }
    }

}