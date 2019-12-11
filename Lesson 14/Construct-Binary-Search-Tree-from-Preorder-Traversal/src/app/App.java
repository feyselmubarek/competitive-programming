package app;

public class App {
    public static void main(String[] args) throws Exception {
        int[] preorder = new int[] { 8, 5, 4, 3, 2, 1 };

        TreeNode n = new Solution().bstFromPreorder(preorder);

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