package Algorithm.Sorting.MergeSort;

import java.util.Arrays;

import Algorithm.Sorting.Sort;

public class MergeSort implements Sort {
    private int[] array;

    public MergeSort(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public int[] sort() {
        divide(array, 0, array.length);
        return array;
    }

    private void divide(int[] arr, int l, int r) {
        if(r - l == 1) {
            return ;
        }

        divide(arr, l, (l + r) / 2);
        divide(arr, (l + r) / 2, r);
        merge(arr, l, (l + r) / 2, r);
    }

    private void merge(int[] arr, int l, int m, int r) {
        int N = r - l, left = l;
        int[] temp = new int[N];

        int index = 0;
        for(int i = m; i < r; i++) {
            if(l == m) {
                while(i < r) {
                    temp[index++] = arr[i++];
                }
                break;
            }

            while(l < m && arr[l] < arr[i]) {
                temp[index++] = arr[l++];
            }
            temp[index++] = arr[i];
        }

        while(l < m) {
            temp[index++] = arr[l++];
        }

        for(int i = 0; i < N; i++) {
            arr[left + i] = temp[i];
        }
    }
    
}
