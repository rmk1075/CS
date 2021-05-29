package DataStructure.List;

// import java.util.Iterator;
// import java.util.ListIterator;

public interface CustomList<E> {
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    // Iterator<E> iterator();
    Object[] toArray();
    boolean add(E e);
    // boolean retainAll(Collection<?> c);
    void clear();
    E get(int index);
    E set(int index, E element);
    // ListIterator<?> listIterator();
    // CustomList<?> subList(int fromIndex, int toIndex);
    public int indexOf(Object o);
}