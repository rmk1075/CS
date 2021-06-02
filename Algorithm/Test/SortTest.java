package Algorithm.Test;

import java.util.Arrays;
import java.util.Random;

import Algorithm.Sorting.Sort;
import Algorithm.Sorting.BubbleSort.BubbleSort;
import Algorithm.Sorting.HeapSort.HeapSort;
import Algorithm.Sorting.InsertionSort.InsertionSort;
import Algorithm.Sorting.MergeSort.MergeSort;
import Algorithm.Sorting.QuickSort.QuickSort;
import Algorithm.Sorting.SelectionSort.SelectionSort;

public class SortTest {
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            try {
                test();
            } catch(Exception e) {
                System.out.println(e);
                break;
            }

        }
    }

    public static void test() {
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

        sort = new MergeSort(arr);
        System.out.print("MergeSort:\t");
        System.out.println(Arrays.toString(sort.sort()));

        sort = new HeapSort(arr);
        System.out.print("HeapSort:\t");
        System.out.println(Arrays.toString(sort.sort()));

        sort = new QuickSort(arr);
        System.out.print("QuickSort:\t");
        System.out.println(Arrays.toString(sort.sort()));
    }
}
