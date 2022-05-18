package DataStructure.src.queue;

import DataStructure.src.common.DataStructure;

public class CustomQueue<E> implements DataStructure<E> {
    private Node<E> front;

    private Node<E> rear;

    private int size;

    public CustomQueue() {}

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean offer(E e) {
        Node<E> last = rear;
        Node<E> newNode = new Node<E>(e, null);
        rear = newNode;
        if(last == null) {
            front = newNode;
        } else {
            last.next = newNode;
        }
        size++;
        return true;
    }

    public E poll() {
        E element = peek();
        if(element != null) {
            this.size--;
            this.front = this.front.next;
        }
        return element;
    }

    public E peek() {
        if(this.size == 0) {
            return null;
        }
        return front.item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E e) {
        Node<E> node = front;
        while(node != null) {
            if(node.item.equals(e)) return true;
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        return this.offer(e);
    }

    @Override
    public Object remove(E e) {
        return null;
    }

    @Override
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }
}
