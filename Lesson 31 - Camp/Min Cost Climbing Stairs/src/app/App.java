package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().minCostClimbingStairs(new int[] { 10, 15, 20 }));
    }

    public int minCostClimbingStairs(int[] cost) {
        return findMin(cost.length, cost, 0);
    }

    public int findMin(int n, int[] arr, int cost) {
        for (int i = 2; i < arr.length; i++) {
            arr[i] += Math.min(arr[i - 1], arr[i - 2]);
        }

        return Math.min(arr[n - 1], arr[n - 2]);
    }
}