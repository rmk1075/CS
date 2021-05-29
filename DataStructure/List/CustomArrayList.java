package DataStructure.List;

import java.util.Arrays;
// import java.util.ListIterator;
// import java.util.Iterator;

public class CustomArrayList<E> implements CustomList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    
    private Object[] elementData;

    private int size;

    public CustomArrayList(int size) {
        this.elementData = new Object[size];
    }

    public CustomArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return 0 <= indexOf(o);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.elementData, this.size);
    }

    @Override
    public void clear() {
        for(int i = 0; i < size; i++) {
            this.elementData[i] = null;
        }
        size = 0;
    }

    public static void checkIndex(int index, int size) {
        if(size <= index) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++) {
            if(elementData[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public Object[] grow() {
        // elementData 의 크기를 두배로 늘려준다.
        return this.elementData = Arrays.copyOf(this.elementData, elementData.length * 2);
    }

    @Override
    public boolean add(E e) {
        if(this.elementData.length <= size) {
            this.elementData = grow();
        }
        this.elementData[size] = e;
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    @Override
    public E get(int index) {
        checkIndex(index, this.size);
        return elementData(index);
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index, this.size);
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }
}
