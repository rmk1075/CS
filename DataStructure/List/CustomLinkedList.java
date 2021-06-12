package DataStructure.List;

public class CustomLinkedList<E> implements CustomList<E> {
    private Node<E> head;

    private Node<E> tail;

    private int size;

    public CustomLinkedList() {}

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
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
    
}
