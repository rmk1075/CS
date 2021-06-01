package Algorithm.Test;

import java.util.Arrays;
import java.util.Random;

import Algorithm.Sorting.Sort;
import Algorithm.Sorting.BubbleSort.BubbleSort;
import Algorithm.Sorting.InsertionSort.InsertionSort;
import Algorithm.Sorting.SelectionSort.SelectionSort;

public class SortTest {
    public static void main(String[] args) {
        int N = 10;
        int[] arr = new int[N];
        Random rand = new Random();

        for(int i = 0; i < N; i++) {
            arr[i] = rand.nextInt(100);
        }
        System.out.print("default:\t");
        System.out.println(Arrays.toString(arr));

        Sort sort;

        sort = new BubbleSort(arr);
        System.out.print("BubbleSort:\t");
        System.out.println(Arrays.toString(sort.sort()));

        sort = new SelectionSort(arr);
        System.out.print("SelectionSort:\t");
        System.out.println(Arrays.toString(sort.sort()));

        sort = new InsertionSort(arr);
        System.out.print("InsertionSort:\t");
        System.out.println(Arrays.toString(sort.sort()));
    }
}
