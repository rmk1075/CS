package Algorithm.Sorting.SelectionSort;

import java.util.Arrays;

import Algorithm.Sorting.Sort;

public class SelectionSort implements Sort {
    private int[] array;

    public SelectionSort(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public int[] sort() {
        int N = array.length;
        for(int i = 0; i < N; i++) {
            int idx = i;
            for(int j = i + 1; j < N; j++) {
                if(array[j] < array[idx]) {
                    idx = j;
                }
            }

            int temp = array[idx];
            array[idx] = array[i];
            array[i] = temp;
        }
        return this.array;
    }
    
}
