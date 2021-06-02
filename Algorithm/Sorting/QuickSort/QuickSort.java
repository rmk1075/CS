package Algorithm.Sorting.QuickSort;

import java.util.Arrays;

import Algorithm.Sorting.Sort;

public class QuickSort implements Sort {

    private int[] array;

    public QuickSort(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public int[] sort() {
        int N = array.length;
        quickSort(array, 0, N - 1);
        return array;
    }

    private void quickSort(int[] arr, int left, int right) {
        if(right <= left)
            return ;
        
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int l = left;
        for(int r = left; r < right; r++) {
            if(arr[r] < pivot) {
                int temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
                l++;
            }
        }

        int temp = arr[l];
        arr[l] = pivot;
        arr[right] = temp;
        return l;
    }
    
}
