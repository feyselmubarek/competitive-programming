package app;

import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        // testing the code
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int[] maxOcu = new int[] { 0, 0 };
        putSubTreeSum(map, root, maxOcu);

        int[] res = new int[maxOcu[1]];
        int i = 0;

        for (int key : map.keySet()) {
            int occ = map.get(key);

            if (occ == maxOcu[0] && i < res.length) {
                res[i] = key;
                i++;
            }
        }

        return res;
    }

    public int putSubTreeSum(HashMap<Integer, Integer> map, TreeNode node, int[] maxOcu) {
        if (node == null) {
            return 0;
        }

        int subTreeSum = node.val;

        if (node.left != null) {
            subTreeSum += putSubTreeSum(map, node.left, maxOcu);
        }

        if (node.right != null) {
            subTreeSum += putSubTreeSum(map, node.right, maxOcu);
        }

        int val = map.containsKey(subTreeSum) ? map.get(subTreeSum) + 1 : 1;
        map.put(subTreeSum, val);

        if (val > maxOcu[0]) {
            maxOcu[0] = val;
            maxOcu[1] = 1;
        } else if (val == maxOcu[0]) {
            maxOcu[1] = maxOcu[1] + 1;
        }

        return subTreeSum;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}