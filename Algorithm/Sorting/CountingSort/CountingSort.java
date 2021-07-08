package Algorithm.Sorting.CountingSort;

import java.util.Arrays;

import Algorithm.Sorting.Sort;

public class CountingSort implements Sort {

    private int[] array;

    private int N;

    // N은 배열에 들어가는 원소의 값의 범위이다.
    public CountingSort(int[] array, int N) {
        this.array = Arrays.copyOf(array, array.length);
        this.N = N;
    }

    @Override
    public int[] sort() {
        // array에 저장된 원소들의 값을 계수한다.
        int[] countingArray = new int[N + 1];
        for(int num : array) {
            countingArray[num]++;
        }

        // 임시 배열에 계수된 만큼 원소들을 차례로 결과 배열에 입력한다.
        int index = 0;
        for(int i = 0; i < N + 1; i++) {
            while(0 < countingArray[i]--) {
                array[index++] = i;
            }
        }

        return array;
    }
    
}
