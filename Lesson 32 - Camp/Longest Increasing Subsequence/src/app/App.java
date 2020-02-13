package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int max = 0, resMax = 0;

        int[] memo = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            max = 0;

            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    if (memo[j] > max) {
                        max = memo[j];
                    }
                }
            }

            memo[i] = max + 1;
            resMax = Math.max(resMax, memo[i]);
        }

        return resMax;
    }
}