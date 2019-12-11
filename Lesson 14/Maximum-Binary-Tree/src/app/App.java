package app;

public class App {
    public static void main(String[] args) throws Exception {
        int[] nums = new int[] { 3, 2, 1, 6, 0, 5 };

        TreeNode n = new Solution().constructMaximumBinaryTree(nums);

        print(n);
    }

    public static void print(TreeNode n) {
        System.out.println(n.val + "=> node ");

        if (n.left != null) {
            print(n.left);
        }

        if (n.right != null) {
            print(n.right);
        }
    }
}