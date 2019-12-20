package app;

public class Solution {
    public int findBottomLeftValue(TreeNode root) {

    }

    public int[] getLevelAndValue(TreeNode node, int level) {
        int[] leftLevelValue = new int[2];
        int[] rightLevelValue = new int[2];

        if (node == null) {
            return null;
        }

        if (node.left != null) {
            leftLevelValue = getLevelAndValue(node.left, (level + 1));
        }

        if (node.right != null) {
            rightLevelValue = getLevelAndValue(node.right, (level + 1));
        }

        return null;
    }
}