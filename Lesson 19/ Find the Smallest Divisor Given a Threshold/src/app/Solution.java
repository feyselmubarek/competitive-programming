package app;

public class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int i = 1, j = 1;
        int divisor = 0;

        j = getMax(nums);

        while (i <= j) {
            divisor = i == j ? i : ((i + j) - 1) / 2;
            int sum = 0;

            for (int k = 0; k < nums.length; k++) {
                sum += nums[k] % divisor == 0 ? nums[k] / divisor : (nums[k] / divisor) + 1;
            }

            if (sum <= threshold) {
                j = divisor - 1;
            } else if (sum > threshold) {
                i = divisor + 1;
            }

        }

        return i;
    }

    private int getMax(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}