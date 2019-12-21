package app;

public class Solution {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int mid = ((i + j) + 1) / 2;

        while (j - i > 1) {
            if (nums[mid] > target) {
                j = mid;
            } else if (nums[mid] < target) {
                i = mid;
            } else {
                return mid;
            }
            mid = ((i + j) + 1) / 2;
        }

        if (nums[i] == target) {
            return i;
        } else if (nums[j] == target) {
            return j;
        }

        return -1;
    }
}
