package app;

public class Solution {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int mid = 0;

        while (i <= j) {
            mid = i == j ? i : ((i + j) - 1) / 2;

            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
