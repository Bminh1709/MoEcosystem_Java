package DynamicArray;

import java.util.Arrays;
import java.util.Iterator;

public class MyArray<E> implements MyList<E> {
    private E[] arr;
    private int capacity;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyArray() {
        capacity = 5;
        arr = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public MyArray(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be bigger than zero");
        this.capacity = capacity;
        arr = (E[]) new Object[capacity];
    }

//    @SuppressWarnings("unchecked")
//    @Override
//    public Boolean add(E element) {
//        if (size >= capacity - 1) {
//            if (capacity == 0) capacity = 1;
//            else {
//                capacity += 10;
//            }
//            E[] newArr = (E[]) new Object[capacity];
//            for (int i = 0; i < arr.length; i++) {
//                newArr[i] = arr[i];
//            }
//            arr = newArr;
//        }
//        arr[size++] = element;
//        return true;
//    }

    @Override
    public Boolean add(E element) {
        if (size >= capacity - 1) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity += 10;
            }
            arr = Arrays.copyOf(arr, capacity);
        }
        arr[size++] = element;
        return true;
    }


    @Override
    public E get(int index) {
        return arr[index];
    }

    @Override
    public boolean set(int index, E element) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        arr[index] = element;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        E removedElement = arr[index];
        arr = shrink(index);
        capacity = --size;
        return removedElement;
    }

    @Override
    public Boolean add(int index, E element) {
        if (size == capacity) {
            arr = grow();
        }
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        else {
            if (index == size) {
                add(element);
            } else {
                for (int i = size - 1; i >= index; i--) {
                    arr[i + 1] = arr[i];
                }
                arr[index] = element;
                size++;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    @Override
    public Boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E[] grow() {
        capacity += 10;
//        E[] newArr = (E[]) new Object[capacity];
//        for (int i = 0; i < arr.length; i++) {
//            newArr[i] = arr[i];
//        }
//        return newArr;
        return Arrays.copyOf(arr, capacity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] shrink(int index) {
        E[] newArr = (E[]) new Object[size-1];

        for (int oldIndex = 0, newIndex = 0; oldIndex < size; oldIndex++, newIndex++) {
            if (oldIndex == index) {
                newIndex--;
            } else {
                newArr[newIndex] = arr[oldIndex];
            }
        }
        return newArr;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(arr[i]);
            if (i < size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return arr[index++];
            }
        };
    }
}
