package app;

public class App {
    public static void main(String[] args) throws Exception {
        int[] nums1 = { 9, 4, 5, 1 };
        int[] nums2 = { 9, 4, 9, 8, 1, 4 };

        int[] a = new Solution().intersection(nums2, nums1);

        System.out.println();
        System.out.print("[ ");
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.print("]");
        System.out.println();
    }
}