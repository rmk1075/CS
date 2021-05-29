package DataStructure.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class CustomStack<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;

    private int size;

    public CustomStack(int size) {
        this.elementData = new Object[size];
    }

    public CustomStack() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return this.size;
    }

    public Object[] grow() {
        // elementData 의 크기를 두배로 늘려준다.
        return this.elementData = Arrays.copyOf(this.elementData, elementData.length * 2);
    }
    
    public E push(E item) {
        if(this.elementData.length <= this.size) {
            this.elementData = grow();
        }
        this.elementData[size] = item;
        this.size++;
        return item;
    }

    public E pop() {
        E element = peek();
        this.size--;
        this.elementData[this.size] = null;
        return element;
    }

    public E peek() {
        if(this.size == 0) {
            throw new EmptyStackException();
        }
        return elementData(this.size - 1);
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) this.elementData[index];
    }
}
