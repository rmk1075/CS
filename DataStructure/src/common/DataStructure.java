package DataStructure.src.common;

public interface DataStructure<E> {
    public long size();
    public boolean isEmpty();
    public boolean contains(E e);
    public void add(E e);
    public Object remove(E e);
}
