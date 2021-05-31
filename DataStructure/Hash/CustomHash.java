package DataStructure.Hash;

import java.util.LinkedList;

public class CustomHash<K, V> {
    class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final static int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    private int capacity;

    private int size;

    LinkedList<Node>[] bucket;

    public CustomHash() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @SuppressWarnings("uncheck")
    public CustomHash(int capacity) {
        this.bucket = new LinkedList[capacity];
        for(int i = 0; i < capacity; i++) {
            this.bucket[i] = new LinkedList<>();
        }
        this.capacity = capacity;
    }

    private int hashFunction(Object key) {
        return key.hashCode() % this.capacity;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public V put(K key, V value) {
        int hashCode = this.hashFunction(key);
        for(Node node : this.bucket[hashCode]) {
            if(node.key.equals(key)) {
                V oldVal = node.value;
                node.value = value;
                return oldVal;
            }
        }

        this.bucket[hashCode].add(new Node(key, value));
        this.size++;
        return null;
    }

    public V get(K key) {
        int hashCode = this.hashFunction(key);
        for(Node node : this.bucket[hashCode]) {
            if(node.key.equals(key)) {
                return node.value;
            }
        }

        return null;
    }
}
