package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().maxJumps(new int[] { 7, 1, 7, 1, 7, 1 }, 2));
    }

    public int maxJumps(int[] arr, int d) {
        int[] memo = new int[arr.length];
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, getMaxJump(arr, memo, i, d));
        }

        return max;
    }

    public int getMaxJump(int[] arr, int[] memo, int n, int d) {
        if (memo[n] == 0) {
            int leftMax = 0, rightMax = 0;

            for (int j = n - 1; j >= 0; j--) {
                if (n - j > d || arr[j] >= arr[n]) {
                    break;
                }

                leftMax = Math.max(leftMax, getMaxJump(arr, memo, j, d));
            }

            for (int k = n + 1; k < arr.length; k++) {
                if (k - n > d || arr[k] >= arr[n]) {
                    break;
                }

                rightMax = Math.max(rightMax, getMaxJump(arr, memo, k, d));
            }

            memo[n] = Math.max(leftMax, rightMax) + 1;
        }

        return memo[n];
    }
}