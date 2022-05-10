package DataStructure.List;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * ArrayList
 * 
 * 배열을 기반으로 데이터를 저장하는 자료구조이다.
 * 저장공간이 정적으로 고정되어 있는 배열과 다르게 capacity 가 full 이 되는 경우 동적으로 배열의 공간을 늘리는 로직 (grow) 이 들어있다. 
 * 
 * 배열을 기반으로 하기 때문에 인덱스를 통한 접근에서 유리하다.
 * 하지만 삽입에서는 요소의 개수가 capacity 에 도달하는 경우 확장을 해주어야 하기 때문에 성능적인 측면에서 불리하다.
 */
public class CustomArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10; // 기본 capacity
    
    private Object[] elementData; // 데이터 저장 공간

    private int size; // 리스트의 크기

    /**
     * Constructor
     * 
     * ArrayList 는 데이터 요소들을 elementData 에 저장한다.
     * 초기 capacity 가 지정된 경우는 해당 값으로 배열을 초기화하고 많약 capacity 가 존재하지 않는 경우 DEFAULT_CAPACITY 로 초기화한다.
     * 
     * 만약 collection 이 매개변수로 입력되면, 해당 collection 이 가지고 있는 데이터를 모두 elementData 에 저장한다.
     */
    public CustomArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayList(int initialCapacity) {
        if(0 < initialCapacity) {
            elementData = new Object[initialCapacity];
        } else if(initialCapacity == 0) {
            elementData = new Object[0];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public CustomArrayList(Collection<? extends E> collection) {
        Object[] arr = collection.toArray();
        size = arr.length;
        if(size == 0) {
            elementData = new Object[0];
        } else {
            elementData = Arrays.copyOf(arr, arr.length, Object[].class);
        }
    }

    /**
     * 리스트의 데이터 저장공간 (배열) 을 늘려준다.
     * 매개변수로 최소 용량 minCapacity 를 입력받는다.
     * - 현재 크기가 0인 경우, minCapacity 와 DEFAULT_CAPACITY 중 더 큰 값으로 크기를 맞춘다.
     * - 0이 아닌 경우, minCapacity 와 현재 크기의 2배를 비교하여 더 큰 값으로 크기를 맞춘다.
     * 
     * @param minCapacity
     * @return
     */
    public Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if(oldCapacity == 0) {
            return elementData = new Object[Math.max(minCapacity, DEFAULT_CAPACITY)];
        } else {
            return elementData = Arrays.copyOf(elementData, oldCapacity + Math.max(oldCapacity, minCapacity - oldCapacity));
        }
    }

    public Object[] grow() {
        return grow(size + 1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(Object e : elementData) {
            if(o.equals(e)) return true;
        }
        return false;
    }
    
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        a = (T[])Arrays.copyOf(elementData, size, a.getClass());
        return a;
    }

    @Override
    public boolean add(E e) {
        add(size, e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i = 0;
        for(; i < size; i++) {
            if(o.equals(elementData[i])) break;
        }
        remove(i);
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object e : c) {
            if(!contains(e)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int newSize = size + c.size();
        if(elementData.length <= newSize) grow(newSize);
        
        int i = size;
        for(E e : c) elementData[i++] = e;

        size = i;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        int csize = c.size();
        int newSize = size + csize;
        if(elementData.length <= newSize) grow(newSize);
        
        // move old datas
        int i = index;
        for(; i < size; i++) elementData[i + csize] = elementData[i];

        // add new datas
        i = index;
        for(E e : c) elementData[i++] = e;

        size += newSize;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        for(int i = 0; i < size; i++) elementData[i] = null;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if(index < size) return (E) elementData[index];
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E set(int index, E element) {
        if(index < size) {
            E oldValue = (E) elementData[index];
            elementData[index] = element;
            return oldValue;
        }
        return null;
    }

    @Override
    public void add(int index, E element) {
        if(elementData.length == index) elementData = grow();
        elementData[index] = element;
        size = index + 1;
    }

    @Override
    public E remove(int index) {
        int i = index;
        for(; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[--size] = null;
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = -1;
        for(int i = 0; i < size; i++) {
            if(o.equals(elementData[i])) break;
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for(int i = size - 1; -1 < i; i--) {
            if(o.equals(elementData[i])) break;
        }
        return index;
    }
    
    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<E> listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if(fromIndex < 0 || size <= toIndex) throw new IllegalArgumentException("Illegal index: " + fromIndex + " " + toIndex);
        return Arrays.asList((E[]) Arrays.copyOfRange(elementData, fromIndex, toIndex));
    }

}
