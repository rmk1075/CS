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
        // 초기 배열의 탐색 대상 범위를 0 ~ N 으로 설정한다.
        int left = 0, right = N;

        // 탐색 대상 범위의 크기가 0이 될때까지 반복한다.
        while(left < right) {
            // 대상 범위의 중간값을 구한다.
            int mid = (left + right) / 2;

            // 중간값과 타겟값이 같은 경우 해당 값의 인덱스를 반환한다.
            if(nums[mid] == val) {
                return mid;

            // 타겟값이 중간값보다 큰 경우 중간값의 오른쪽 부분 배열을 대상으로 탐색을 진행한다.
            } else if(nums[mid] < val) {
                left = mid + 1;

            // 타겟값이 중간값보다 작은 경우 중간값의 왼쪽 부분 배열을 대상으로 탐색을 진행한다.
            } else {
                right = mid;
            }
        }
        // 타겟값이 없는 경우 -1을 반환한다.
        return -1;
    }
    
}
