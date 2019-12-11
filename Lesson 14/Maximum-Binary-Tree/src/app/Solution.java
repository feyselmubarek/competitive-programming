package app;

import java.util.Arrays;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode node, leftNode = null, rightNode = null;

        if (nums.length == 0) {
            return null;
        }

        int maxIndex = getMaxIndex(nums);

        node = new TreeNode(nums[maxIndex]);

        int[] leftArray = Arrays.copyOfRange(nums, 0, maxIndex);
        int[] rightArray = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);

        if (leftArray.length != 0) {
            leftNode = constructMaximumBinaryTree(leftArray);
        }

        if (rightArray.length != 0) {
            rightNode = constructMaximumBinaryTree(rightArray);
        }

        if (leftNode != null) {
            node.left = leftNode;
        }

        if (rightNode != null) {
            node.right = rightNode;
        }

        return node;
    }

    public int getMaxIndex(int[] nums) {
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}