package ADT;

public interface ArrayADT<E> extends Iterable<E> {
    Boolean add (E element);
    Boolean add (int index, E element);
    E get (int index);
    boolean set (int index, E element);
    E remove (int index);
    int size ();
    int indexOf (E element);
    Boolean contains (E element);
    Boolean isEmpty ();
    E[] grow();
    E[] shrink(int index);

}
