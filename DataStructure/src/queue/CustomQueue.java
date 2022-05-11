package DataStructure.src.queue;

public class CustomQueue<E> {
    private Node<E> front;

    private Node<E> rear;

    private int size;

    public CustomQueue() {}

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean offer(E e) {
        Node<E> last = rear;
        Node<E> newNode = new Node<E>(rear, e, null);
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
}
