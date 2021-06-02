package Algorithm.Sorting.CountingSort;

import java.util.Arrays;

import Algorithm.Sorting.Sort;

public class CountingSort implements Sort {

    private int[] array;

    private int N;

    public CountingSort(int[] array, int N) {
        this.array = Arrays.copyOf(array, array.length);
        this.N = N;
    }

    @Override
    public int[] sort() {
        int[] countingArray = new int[N + 1];
        for(int num : array) {
            countingArray[num]++;
        }

        int index = 0;
        for(int i = 0; i < N + 1; i++) {
            while(0 < countingArray[i]--) {
                array[index++] = i;
            }
        }

        return array;
    }
    
}
