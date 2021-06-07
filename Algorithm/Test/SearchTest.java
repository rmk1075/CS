package Algorithm.Test;

import java.util.Arrays;
import java.util.Random;

import Algorithm.Search.Search;
import Algorithm.Search.BinarySearch.BinarySearch;

public class SearchTest {
    public static void main(String[] args) {
        Random random = new Random();
        int N = random.nextInt(20) + 1;
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) nums[i] = random.nextInt(100);

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        Search search;
        int val = nums[random.nextInt(N)];

        search = new BinarySearch(nums);
        System.out.println(val + " " + search.search(val));
    }
}
