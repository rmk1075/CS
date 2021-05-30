package DataStructure.Tree;

import java.util.Arrays;
import java.util.Comparator;

public class CustomHeap implements CustomTree {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;

    private int size;

    private final Comparator<Integer> comparator;

    public CustomHeap() {
        this(DEFAULT_CAPACITY, null);
    }

    public CustomHeap(int size, Comparator<Integer> comparator) {
        if(size < 1) {
            throw new IllegalArgumentException();
        }
        this.elementData = new Object[size];
        this.comparator = comparator;
        this.size = 1;
    }

    private Object[] grow() {
        return this.elementData = Arrays.copyOf(this.elementData, this.elementData.length * 2);
    }

    private void siftUp(int index, int target) {
        if(this.comparator != null) {
            siftUpUsingComparator(index, target, this.elementData, this.comparator);
        } else {
            siftUpComparable(index, target, this.elementData);
        }
    }

    private static void siftUpUsingComparator(int index, int target, Object[] es, Comparator<Integer> cmp) {
        while(1 < index) {
            int parent = index / 2;
            Object e = es[parent];
            if(cmp.compare(target, (Integer) e) >= 0)
                break;
            es[index] = e;
            index = parent;
        }
        es[index] = target;
    }

    private static void siftUpComparable(int index, int target, Object[] es) {
        Comparable<Integer> key = (Comparable<Integer>) target;
        while(1 < index) {
            int parent = index / 2;
            Object e = es[parent];
            if(key.compareTo((Integer) e) >= 0)
                break;
            es[index] = e;
            index = parent;
        }
        es[index] = key;
    }

    @Override
    public boolean insert(int value) {
        for(int i = 1; i < this.size; i++) {
            if(this.elementData[i].equals(value)) {
                return false;
            }
        }
        if(this.elementData.length <= size) {
            this.elementData = grow();
        }
        siftUp(size, value);
        this.size++;
        return true;
    }

    private void siftDown(int index, int target) {
        if(comparator != null) {
            siftDownUsingComparator(index, target, this.elementData, this.size, this.comparator);
        } else {
            siftDownComparable(index, target, this.elementData, this.size);
        }
    }

    private static void siftDownUsingComparator(int index, int target, Object[] es, int size, Comparator<Integer> cmp) {
        int half = size >>> 1;
        while(index < half) {
            int child = (index << 1) + 1;
            Object c = es[child];
            int right = child + 1;
            if(right < size && cmp.compare((Integer) c, (Integer) es[right]) > 0)
                c = es[child = right];
            if(cmp.compare(target, (Integer) c) <= 0)
                break;
            es[index] = c;
            index = child;
        }
        es[index] = target;
    }

    @SuppressWarnings("unchecked")
    private static void siftDownComparable(int index, int target, Object[] es, int size) {
        Comparable<Integer> key = (Comparable<Integer>) target;
        int half = size >>> 1;
        while(index < half) {
            int child = (index << 1) + 1;
            Object c = es[child];
            int right = child + 1;
            if(right < size && ((Comparable<Integer>) c).compareTo((Integer) es[right]) > 0)
                c = es[child = right];
            if(key.compareTo((Integer) c) <= 0)
                break;
            es[index] = c;
            index = child;
        }
        es[index] = key;
    }

    private void removeAt(int index) {
        int size = --this.size;
        if(size == index) {
            this.elementData[size] = null;
        } else {
            Integer moved = (Integer) this.elementData[size];
            elementData[size] = null;
            siftDown(index, moved);
            if(this.elementData[index] == moved) {
                siftUp(index, moved);
                if(this.elementData[index] != moved)
                    return ;
            }
        }
    }

    @Override
    public boolean remove(int value) {
        for(int i = 1; i <= this.size; i++) {
            if(this.elementData[i].equals(value)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public void preOrder(int index) {
        System.out.println(elementData[index]);
        int next = index * 2;
        if(next < this.size) {
            preOrder(next);
        }
        if(next + 1 < this.size) {
            preOrder(next + 1);
        }
    }

    @Override
    public void preOrder() {
        if(this.size != 1)
            preOrder(1);
    }

    public void inOrder(int index) {
        int next = index * 2;
        if(next < this.size) {
            inOrder(next);
        }
        System.out.println(this.elementData[index]);
        if(next + 1 < this.size) {
            inOrder(next + 1);
        }
    }

    @Override
    public void inOrder() {
        if(this.size != 1)
            inOrder(1);
    }

    public void postOrder(int index) {
        int next = index * 2;
        if(next < this.size) {
            postOrder(next);
        }
        if(next + 1 < this.size) {
            postOrder(next + 1);
        }
        System.out.println(this.elementData[index]);
    }

    @Override
    public void postOrder() {
        if(this.size != 1)
            postOrder(1);
    }
}
