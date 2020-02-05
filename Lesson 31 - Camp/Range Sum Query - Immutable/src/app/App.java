package app;

public class App {
    int[] sumArr;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public App(int[] nums) {
        sumArr = new int[nums.length + 1];
        int sum = 0;

        for (int i = 1; i < sumArr.length; i++) {
            sum += nums[i - 1];
            sumArr[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumArr[j + 1] - sumArr[i];
    }
}