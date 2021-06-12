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
        this.size = 0;
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
        while(0 < index) {
            int parent = (index - 1) / 2;
            Object e = es[parent];
            if(cmp.compare(target, (Integer) e) > 0)
                break;
            es[index] = e;
            index = parent;
        }
        es[index] = target;
    }

    private static void siftUpComparable(int index, int target, Object[] es) {
        Comparable<Integer> key = (Comparable<Integer>) target;
        while(0 < index) {
            int parent = (index - 1) / 2;
            Object e = es[parent];
            if(key.compareTo((Integer) e) > 0)
                break;
            es[index] = e;
            index = parent;
        }
        es[index] = key;
    }

    @Override
    public boolean insert(int value) {
        // check the value is unique or not
        for(int i = 0; i < this.size; i++) {
            if(this.elementData[i].equals(value)) {
                return false;
            }
        }

        // check array size
        if(this.elementData.length <= size) {
            this.elementData = grow();
        }

        // compare and insert
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
        while(index * 2 + 1 <= size) {
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
        while(index * 2 + 1 <= size) {
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
        for(int i = 0; i <= this.size; i++) {
            if(this.elementData[i].equals(value)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    private void preOrder(int index) {
        System.out.print(elementData[index] + " ");
        int next = index * 2 + 1;
        if(next < this.size) {
            preOrder(next);
        }
        if(next + 1 < this.size) {
            preOrder(next + 1);
        }
    }

    @Override
    public void preOrder() {
        if(this.size != 0)
            preOrder(0);
        System.out.println();
    }

    private void inOrder(int index) {
        int next = index * 2 + 1;
        if(next < this.size) {
            inOrder(next);
        }
        System.out.print(this.elementData[index] + " ");
        if(next + 1 < this.size) {
            inOrder(next + 1);
        }
    }

    @Override
    public void inOrder() {
        if(this.size != 0)
            inOrder(0);
        System.out.println();
    }

    private void postOrder(int index) {
        int next = index * 2 + 1;
        if(next < this.size) {
            postOrder(next);
        }
        if(next + 1 < this.size) {
            postOrder(next + 1);
        }
        System.out.print(this.elementData[index] + " ");
    }

    @Override
    public void postOrder() {
        if(this.size != 0)
            postOrder(0);
        System.out.println();
    }
}
