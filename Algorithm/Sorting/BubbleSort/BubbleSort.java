package Algorithm.Sorting.BubbleSort;

import java.util.Arrays;

import Algorithm.Sorting.Sort;

public class BubbleSort implements Sort {
    private int[] array;

    public BubbleSort(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public int[] sort() {
        int N = array.length;
        for(int i = 0; i < N - 1; i++) {
            for(int j = 1; j < N - i; j++) {
                if(array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        return array;
    }
}
