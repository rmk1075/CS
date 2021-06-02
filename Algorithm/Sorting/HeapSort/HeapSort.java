package Algorithm.Sorting.HeapSort;

import java.util.Arrays;

import Algorithm.Sorting.Sort;

public class HeapSort implements Sort {

    private int[] array;

    public HeapSort(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public int[] sort() {
        buildMaxHeap(array);
        heapSort(array);
        return array;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private void heapify(int[] array, int N, int parent) {
        int targetIdx, leftChild, rightChild;
        while(parent * 2 + 1 < N) {
            targetIdx = parent;
            leftChild = parent * 2 + 1;
            rightChild = parent * 2 + 2;

            if(leftChild < N) targetIdx = array[targetIdx] < array[leftChild] ? leftChild : targetIdx;
            if(rightChild < N) targetIdx = array[targetIdx] < array[rightChild] ? rightChild : targetIdx;
            if(targetIdx != parent) {
                int temp = array[targetIdx];
                array[targetIdx] = array[parent];
                array[parent] = temp;
                parent = targetIdx;
            } else return ;
        }
    }

    private void buildMaxHeap(int[] array) {
        int N = array.length;

        for(int i = getParent(N - 1); -1 < i; i--) {
            heapify(array, N, i);
        }
    }

    private void heapSort(int[] array) {
        int N = array.length;
        for(int i = 1; i < N; i++) {
            int temp = array[N - i];
            array[N - i] = array[0];
            array[0] = temp;
            heapify(array, N - i, 0);
        }
    }
    
}