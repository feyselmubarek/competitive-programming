package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % k != 0) {
            return false;
        }

        boolean[] visted = new boolean[nums.length];

        return canPartition(0, nums, visted, k, 0, sum / k);
    }

    public boolean canPartition(int start, int[] nums, boolean[] visted, int k, int currentSum, int targetSum) {
        if (k == 1) {
            return true;
        }

        if (currentSum > targetSum) {
            return false;
        }

        if (currentSum == targetSum) {
            return canPartition(0, nums, visted, k - 1, 0, targetSum);
        }

        for (int i = start; i < nums.length; i++) {
            if (!visted[i]) {
                visted[i] = true;
                if (canPartition(i + 1, nums, visted, k, currentSum + nums[i], targetSum)) {
                    return true;
                }
                visted[i] = false;
            }
        }

        return false;
    }
}