package app;

public class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0, j = nums.length - 1, mid = 0;

        while (i <= j) {
            mid = i == j ? i : (j + i - 1) / 2;
            int numberElemToMid = 0;

            for (int k = 0; k < nums.length; k++) {
                numberElemToMid += nums[k] <= mid ? 1 : 0;
            }

            if (numberElemToMid > mid) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return i;
    }
}