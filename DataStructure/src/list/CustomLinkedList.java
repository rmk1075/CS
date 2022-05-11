package DataStructure.src.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomLinkedList<E> implements List<E> {
    private Node<E> head;

    private Node<E> tail;

    private int size;

    public CustomLinkedList() {}

    public CustomLinkedList(Collection<? extends E> c) {
        addAll(c);
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> node = head;
        while(node != null) {
            if(node.item == o) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<E>  node = head;
        for(int i = 0; i < size; i++) {
            array[i] = node.item;
            node = node.next;
        }
        return array;
    }

    @Override
    public boolean add(E e) {
        Node<E> last = tail;
        Node<E> newNode = new Node<E>(tail, e, null);
        tail = newNode;
        if(last == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public void clear() {
        Node<E> node = head;
        while(node != null) {
            Node<E> next = node.next;
            node.item = null;
            node.next = null;
            node = next;
        }
        head = tail = null;
        size = 0;
    }

    private static void checkIndex(int index, int size) {
        if(size <= index) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E get(int index) {
        checkIndex(index, size);
        Node<E> node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index, size);
        Node<E> node = head;
        E oldVal = null;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        oldVal = node.item;
        node.item = element;
        return oldVal;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> node = head;
        for(int i = 0; i < size; i++) {
            if(node.item.equals(o)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> node = head;
        while(node != null) {
            if(o.equals(node.item)) {
                if(node == head) {
                    head = node.next;
                }
                
                if(node == tail) {
                    tail = node.prev;
                }

                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        for(Object o : c) {
            if(!contains(o)) return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(Collection c) {
        for(Object o : c) {
            add((E) o);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void add(int index, Object element) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public E remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }
}
