package DataStructure.test;

import DataStructure.src.tree.CustomHeap;

public class HeapTest {
    public static void main(String[] args) {
        CustomHeap heap = new CustomHeap();

        System.out.println("insert");
        for(int i = 0; i < 10; i++) {
            int val = i % 2 == 0 ? i : i * -1;
            heap.insert(val);
            System.out.println("i: " + val);
            heap.preOrder();
        }

        System.out.println("remove");
        for(int i = 0; i < 10; i++) {
            int val = i % 2 == 0 ? i : i * -1;
            heap.remove(val);
            System.out.println("i: " + val);
            heap.preOrder();
        }
    }    
}
