package Algorithm.Sorting.InsertionSort;

import java.util.Arrays;

import Algorithm.Sorting.Sort;

public class InsertionSort implements Sort {
    private int[] array;

    public InsertionSort(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public int[] sort() {
        int N = array.length;
        for(int i = 1; i < N; i++) {
            for(int j = i - 1; -1 < j; j--) {
                if(array[j] < array[j + 1])
                    break;
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
        return array;
    }
    
}
