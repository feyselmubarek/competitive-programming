package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().singleNumber(new int[] { 1, 2, 3, 5 }));
    }

    public int singleNumber(int[] nums) {
        int res = 0;

        for (int num = 0; num < nums.length; num++) {
            res ^= nums[num];
        }

        return res;
    }
}