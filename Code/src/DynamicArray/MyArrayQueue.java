package DynamicArray;

public class MyArrayQueue<E> implements AbstractQueue<E> {

    private MyArray<E> myArray;

    public MyArrayQueue() {
        this.myArray = new MyArray<>();
    }

    @Override
    public void offer(E element) {
        myArray.add(element);
    }

    @Override
    public E poll() {
        if (isEmpty())
            throw new IllegalStateException("Array is empty");
        else {
            E removedElement = myArray.get(0);
            myArray.remove(0);
            return removedElement;
        }
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new IllegalStateException("Array is empty");
        else
            return myArray.get(0);
    }

    @Override
    public int size() {
        return myArray.size();
    }

    @Override
    public boolean isEmpty() {
        return myArray.isEmpty();
    }
}
