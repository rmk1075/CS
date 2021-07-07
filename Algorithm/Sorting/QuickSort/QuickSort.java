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
        
        // pivot을 기준으로 partition을 진행한다.
        int pivot = partition(arr, left, right);
        
        // pivot의 위치를 기준으로 left, right에 대해서 재귀적으로 정렬을 반복한다.
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        // pivot으로 대상 구간의 가장 오른쪽 원소를 선택한다.
        int pivot = arr[right];

        // 대상 구간의 left, right 인덱스를 가지고 정렬을 진행한다.
        int l = left;
        for(int r = left; r < right; r++) {
            // pivot 보다 작은 값의 경우 left에 있는 값과 자리를 바꾼후 l을 한칸 오른쪽으로 옮긴다. (오름차순 기준)
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
