package app;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int minDiffInBST(TreeNode root) {
        ArrayList<TreeNode> stack = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.remove(stack.size() - 1);
            list.add(node.val);

            if (node.left != null)
                stack.add(node.left);

            if (node.right != null)
                stack.add(node.right);
        }

        performQuickSort(0, list.size() - 1, list);

        int first = list.get(0);
        int second = list.get(1);
        int min = second - first;

        for (int i = 2; i < list.size(); i++) {
            first = second;
            second = list.get(i);
            min = (second - first) < min ? (second - first) : min;
        }

        return min;
    }

    public static void performQuickSort(int initialIndex, int finalIdnex, ArrayList<Integer> arrayList) {

        if (initialIndex < finalIdnex) {
            int pivIndex = getSortedPivotIndex(initialIndex, finalIdnex, arrayList);
            performQuickSort(initialIndex, pivIndex - 1, arrayList);
            performQuickSort(pivIndex + 1, finalIdnex, arrayList);
        }
    }

    public static int getSortedPivotIndex(int intialIndex, int finalIndex, ArrayList<Integer> arrayList) {
        int pivot = arrayList.get(intialIndex);
        int pivotIndex = intialIndex;

        while (intialIndex < finalIndex) {

            try {
                while (arrayList.get(intialIndex) <= pivot) {
                    intialIndex++;
                }

                while (arrayList.get(finalIndex) >= pivot) {
                    finalIndex--;
                }
            } catch (Exception e) {
            }

            if (intialIndex < finalIndex) {
                Collections.swap(arrayList, intialIndex, finalIndex);
            }
        }

        if (finalIndex > pivotIndex) {
            Collections.swap(arrayList, finalIndex, pivotIndex);
            return finalIndex;
        }
        return pivotIndex;
    }
}