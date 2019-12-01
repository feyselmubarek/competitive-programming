package app;

public class App {
    public static void main(String[] args) throws Exception {
        int[] nums = new int[] { 1, 1, 1, 2, 2, 2 };

        nums = new Solution().rearrangeBarcodes(nums);

        System.out.println();
        for (int i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}