package app;

import java.util.Arrays;

public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode node, leftNode = null, rightNode = null;

        if (preorder.length == 0) {
            return null;
        }

        if (preorder.length <= 1) {
            return new TreeNode(preorder[0]);
        }
        node = new TreeNode(preorder[0]);

        int maxIndex = getGreaterIndex(preorder);
        int[] leftArray;

        if (maxIndex != 0) {
            leftArray = Arrays.copyOfRange(preorder, 1, maxIndex);
        } else {
            leftArray = Arrays.copyOfRange(preorder, 1, preorder.length);
        }

        int[] rightArray = Arrays.copyOfRange(preorder, maxIndex, preorder.length);

        if (leftArray.length != 0) {
            leftNode = bstFromPreorder(leftArray);
        }

        if ((rightArray.length != 0) && (maxIndex != 0)) {
            rightNode = bstFromPreorder(rightArray);
        }

        node.left = leftNode != null ? leftNode : null;
        node.right = rightNode != null ? rightNode : null;

        return node;
    }

    public int getGreaterIndex(int[] nums) {
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
                break;
            }
        }

        return maxIndex;
    }
}