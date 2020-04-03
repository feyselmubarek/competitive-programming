package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().maxSubArray(new int[] { 1, 2, 3, -1, 4, -2, -5 }));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return -2147483648;
        }

        // Kadane's Algorithms
        int maxPrev = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxPrev = Math.max(maxPrev + nums[i], nums[i]);
            maxSum = Math.max(maxSum, maxPrev);
        }

        return maxSum;
    }
}