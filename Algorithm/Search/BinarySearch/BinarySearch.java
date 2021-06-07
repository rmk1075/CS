package Algorithm.Search.BinarySearch;

import java.util.Arrays;

import Algorithm.Search.Search;

public class BinarySearch implements Search {

    private int N;

    private int[] nums;

    public BinarySearch(int[] nums) {
        N = nums.length;
        this.nums = Arrays.copyOf(nums, N);
    }

    @Override
    public int search(int val) {
        int left = 0, right = N;
        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] == val) {
                return mid;
            } else if(nums[mid] < val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
    
}
