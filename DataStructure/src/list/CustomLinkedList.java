package DataStructure.src.list;

import java.util.Collection;

import DataStructure.src.common.DataStructure;

/**
 * LinkedList
 * 
 * ArrayList 와 달리 배열이 아닌 노드들의 연결을 기반으로 데이터를 저장하는 자료구조이다.
 * 내부 클래스인 Node 를 사용하여 데이터를 저장하고 데이터의 추가, 삭제에 따라 Node 들의 연결과 해제를 수행한다.
 * 
 * Node 의 연결을 통해서 자료구조를 구성하기 때문에 배열처럼 확장을 해주지 않아도 되서 새로운 값의 삽입과 삭제는 유리하다.
 * 하지만 배열과 같이 인덱스를 사용하여 바로 접근할 수 없고, 처음 head 부터 탐색을 수행해야 하기 때문에 검색에는 불리하다.
 */
public class CustomLinkedList<E> implements DataStructure<E> {
    private Node<E> head;

    private Node<E> tail;

    private int size;

    public CustomLinkedList() {}

    public CustomLinkedList(Collection<? extends E> c) {
        addAll(c);
    }

    /**
     * Node
     * 
     * LinkedList 의 Node 는 저장할 데이터 값과 연결된 Node 들의 정보를 저장한다.
     * next 는 해당 Node 의 다음 Node, prev 는 해당 Node 의 이전 Node 이다.
     * 이 참조를 통해서 LinkedList 가 chain 을 구성한다.
     */
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
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
    public boolean contains(E e) {
        Node<E> node = head;
        while(node != null) {
            if(e.equals(node.element)) return true;
            node = node.next;
        }
        return false;
    }

    public boolean containsAll(Collection<E> c) {
        for(E e : c) {
            if(!contains(e)) return false;
        }
        return true;
    }

    @Override
    public boolean add(E e) {
        Node<E> lastNode = tail;
        Node<E> newNode = new Node<E>(tail, e, null);
        tail = newNode;

        if(lastNode == null) {
            head = newNode;
        } else {
            lastNode.next = newNode;
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        for(E e : c) {
            add((E) e);
        }
        return true;
    }

    @Override
    public Object remove(E e) {
        Node<E> node = head;
        while(node != null) {
            if(e.equals(node.element)) {
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
    public void clear() {
        Node<E> node = head;
        while(node != null) {
            Node<E> next = node.next;
            node.element = null;
            node.next = null;
            node.prev = null;
            node = next;
        }
        head = tail = null;
        size = 0;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<E>  node = head;
        for(int i = 0; i < size; i++) {
            array[i] = node.element;
            node = node.next;
        }
        return array;
    }

    private static void checkIndex(int index, int size) {
        if(size <= index) {
            throw new IndexOutOfBoundsException();
        }
    }

    public E get(int index) {
        checkIndex(index, size);
        Node<E> node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.element;
    }

    public E set(int index, E element) {
        checkIndex(index, size);
        Node<E> node = head;
        E oldVal = null;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        oldVal = node.element;
        node.element = element;
        return oldVal;
    }

    public int indexOf(Object o) {
        Node<E> node = head;
        for(int i = 0; i < size; i++) {
            if(node.element.equals(o)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }
}
