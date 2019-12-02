package app;

public class App {
    public static void main(String[] args) throws Exception {
        int[] nums = { 0, 4, 3, 0 };
        int target = 0;

        Solution solution = new Solution();
        System.out.println(solution.twoSum(nums, target)[0] + " " + solution.twoSum(nums, target)[1]);
    }
}