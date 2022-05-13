package DataStructure.src.common;

public interface DataStructure<E> {
    public int size();
    public boolean isEmpty();
    public boolean contains(E e);
    public boolean add(E e);
    public Object remove(E e);
    public void clear();
}
