package person;

public class MyArrayList<E> {

    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;


    public MyArrayList() {
        super();
        if (INIT_SIZE < 0)
            throw new IllegalArgumentException("Illegal Capacity: " +
                    INIT_SIZE);
        this.array = new Object[INIT_SIZE];
    }

    /*
    Добавляет новый элемент в список. При достижении размера внутреннего
    массива происходит его увеличение в два раза.
    */
    public void add(E item) {
        if (pointer == array.length - 1)
            resize(array.length * 2); // увеличу в 2 раза, если достигли границ
        array[pointer++] = item;
    }

    /*
    Возвращает элемент списка по индексу.
    */
    public E get(int index) {
        return (E) array[index];
    }

    /*
    *
    Удаляет элемент списка по индексу. Все элементы справа от удаляемого
    перемещаются на шаг налево. Если после удаления элемента количество
    элементов стало в CUT_RATE раз меньше чем размер внутреннего массива,
    то внутренний массив уменьшается в два раза, для экономии занимаемого
    места.
    */
    public void remove(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length / 2); // если элементов в CUT_RATE раз меньше чем
        // длина массива, то уменьшу в два раза
    }

    /*Возвращает количество элементов в списке*/
    public int size() {
        return pointer;
    }

    /*Вспомогательный метод для масштабирования.*/
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}


//import java.util.AbstractList;
//import java.util.List;
//import java.util.RandomAccess;
//import java.util.Collection;
//import java.util.Arrays;
//
//public class MyArrayList<E> extends AbstractList<E>
//        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
//    private static final long serialVersionUID = 8683452581122892189L;
//
//
//    private transient Object[] elementData;
//    private int size;
//
//    public MyArrayList(int initialCapacity) {
//        super();
//        if (initialCapacity < 0)
//            throw new IllegalArgumentException("Illegal Capacity: " +
//                    initialCapacity);
//        this.elementData = new Object[initialCapacity];
//    }
//
//    public MyArrayList() {
//        this(10);
//    }
//
//    public MyArrayList(Collection<? extends E> c) {
//        elementData = c.toArray();
//        size = elementData.length;
//        // c.toArray might (incorrectly) not return Object[] (see 6260652)
//        if (elementData.getClass() != Object[].class)
//            elementData = Arrays.copyOf(elementData, size, Object[].class);
//    }
//
//    public void trimToSize() {
//        modCount++;
//        int oldCapacity = elementData.length;
//        if (size < oldCapacity) {
//            elementData = Arrays.copyOf(elementData, size);
//        }
//    }
//    public void ensureCapacity(int minCapacity) {
//        if (minCapacity > 0)
//            ensureCapacityInternal(minCapacity);
//    }
//
//    private void ensureCapacityInternal(int minCapacity) {
//        modCount++;
//        // overflow-conscious code
//        if (minCapacity - elementData.length > 0)
//            grow(minCapacity);
//    }
//    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
//
//    private void grow(int minCapacity) {
//        // overflow-conscious code
//        int oldCapacity = elementData.length;
//        int newCapacity = oldCapacity + (oldCapacity >> 1);
//        if (newCapacity - minCapacity < 0)
//            newCapacity = minCapacity;
//        if (newCapacity - MAX_ARRAY_SIZE > 0)
//            newCapacity = hugeCapacity(minCapacity);
//        // minCapacity is usually close to size, so this is a win:
//        elementData = Arrays.copyOf(elementData, newCapacity);
//    }
//
//    private static int hugeCapacity(int minCapacity) {
//        if (minCapacity < 0) // overflow
//            throw new OutOfMemoryError();
//        return (minCapacity > MAX_ARRAY_SIZE) ?
//                Integer.MAX_VALUE :
//                MAX_ARRAY_SIZE;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    public boolean contains(Object o) {
//        return indexOf(o) >= 0;
//    }
//
//    public int indexOf(Object o) {
//        if (o == null) {
//            for (int i = 0; i < size; i++)
//                if (elementData[i]==null)
//                    return i;
//        } else {
//            for (int i = 0; i < size; i++)
//                if (o.equals(elementData[i]))
//                    return i;
//        }
//        return -1;
//    }
//
//    public int lastIndexOf(Object o) {
//        if (o == null) {
//            for (int i = size-1; i >= 0; i--)
//                if (elementData[i]==null)
//                    return i;
//        } else {
//            for (int i = size-1; i >= 0; i--)
//                if (o.equals(elementData[i]))
//                    return i;
//        }
//        return -1;
//    }
//
//    public Object[] toArray() {
//        return Arrays.copyOf(elementData, size);
//    }
//
//    @SuppressWarnings("unchecked")
//    public <T> T[] toArray(T[] a) {
//        if (a.length < size)
//            // Make a new array of a's runtime type, but my contents:
//            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
//        System.arraycopy(elementData, 0, a, 0, size);
//        if (a.length > size)
//            a[size] = null;
//        return a;
//    }
//
//    // Positional Access Operations
//
//    @SuppressWarnings("unchecked")
//    E elementData(int index) {
//        return (E) elementData[index];
//    }
//
//    public E get(int index) {
//        rangeCheck(index);
//
//        return elementData(index);
//    }
//
//    public E set(int index, E element) {
//        rangeCheck(index);
//
//        E oldValue = elementData(index);
//        elementData[index] = element;
//        return oldValue;
//    }
//
//
//    public boolean add(E e) {
//        ensureCapacityInternal(size + 1);  // Increments modCount!!
//        elementData[size++] = e;
//        return true;
//    }
//
//
//    public void add(int index, E element) {
//        rangeCheckForAdd(index);
//
//        ensureCapacityInternal(size + 1);  // Increments modCount!!
//        System.arraycopy(elementData, index, elementData, index + 1,
//                size - index);
//        elementData[index] = element;
//        size++;
//    }
//
//    public E remove(int index) {
//        rangeCheck(index);
//
//        modCount++;
//        E oldValue = elementData(index);
//
//        int numMoved = size - index - 1;
//        if (numMoved > 0)
//            System.arraycopy(elementData, index+1, elementData, index,
//                    numMoved);
//        elementData[--size] = null; // Let gc do its work
//
//        return oldValue;
//    }
//
//
//    private void fastRemove(int index) {
//        modCount++;
//        int numMoved = size - index - 1;
//        if (numMoved > 0)
//            System.arraycopy(elementData, index+1, elementData, index,
//                    numMoved);
//        elementData[--size] = null; // Let gc do its work
//    }
//
//    public void clear() {
//        modCount++;
//
//        // Let gc do its work
//        for (int i = 0; i < size; i++)
//            elementData[i] = null;
//
//        size = 0;
//    }
//
//    private void rangeCheck(int index) {
//        if (index >= size)
//            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//    }
//
//    private void rangeCheckForAdd(int index) {
//        if (index > size || index < 0)
//            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//    }
//
//    private String outOfBoundsMsg(int index) {
//        return "Index: "+index+", Size: "+size;
//    }
//
//}