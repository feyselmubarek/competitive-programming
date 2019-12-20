package app;

public class App {
    public static void main(String[] args) throws Exception {
        int[] nums = new int[] { 1 };

        nums = new Solution2().rearrangeBarcodes(nums);

        System.out.println();
        for (int i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}