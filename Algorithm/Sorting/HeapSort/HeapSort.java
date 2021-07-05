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
        // 1. max heap 생성
        buildMaxHeap(array);

        // 2. root node 추출하여 정렬 및 heapify 과정을 반복한다.
        heapSort(array);
        return array;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    // parent 와 children을 비교하여 더 큰 값을 parent 값으로 하는 방식으로 heapify 진행한다.
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

    // max heap 구성
    private void buildMaxHeap(int[] array) {
        int N = array.length;

        for(int i = getParent(N - 1); -1 < i; i--) {
            heapify(array, N, i);
        }
    }

    // heap sort 진행
    private void heapSort(int[] array) {
        int N = array.length;
        for(int i = 1; i < N; i++) {
            // max 값과 array 의 i 위치에 있는 값의 자리를 바꿔 정렬한다.
            int temp = array[N - i];
            array[N - i] = array[0];
            array[0] = temp;

            // i 이후의 값들에 대해서 heapify를 통해서 가장 큰 값을 찾기 위해 heapify 를 구한다.
            heapify(array, N - i, 0);
        }
    }
    
}