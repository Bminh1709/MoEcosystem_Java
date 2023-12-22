package DynamicArray;

import java.util.EmptyStackException;

public class MyArrayStack<E> implements AbstractStack<E> {

    private MyArray<E> myArray;
    private int lastIndex = -1;

    public MyArrayStack() {
        this.myArray = new MyArray<>();
    }

    @Override
    public void push(E element) {
        lastIndex++;
        myArray.add(element);
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new IllegalStateException("The array stack is empty");
        else {
            E removedElement = myArray.get(lastIndex);
            myArray.remove(lastIndex);
            lastIndex--;
            return removedElement;
        }
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return myArray.get(lastIndex);
    }

    @Override
    public int size() {
        return myArray.size();
    }

    @Override
    public boolean isEmpty() {
        return myArray.isEmpty();
    }

    @Override
    public String toString() {
        return myArray.toString();
    }
}
