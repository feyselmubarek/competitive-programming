package app;

import java.util.Stack;

public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        return getNextLargestArray(head);
    }

    public int[] getNextLargestArray(ListNode head) {
        // reversing linked list
        ListNode prev = head;
        ListNode curr = prev.next;

        prev.next = null;
        ListNode next;
        int size = 1;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
            size++;
        }

        int[] nextLargeArr = new int[size];
        populateNextLarge(nextLargeArr, prev);

        return nextLargeArr;
    }

    public void populateNextLarge(int[] nextLargeArr, ListNode node) {
        Stack<Integer> stack = new Stack<>();
        int index = nextLargeArr.length - 1;

        while (index >= 0) {
            int nextLarge = 0;

            while (!stack.isEmpty() && stack.peek() <= node.val) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                nextLarge = stack.peek();
            }

            nextLargeArr[index] = nextLarge;
            index--;

            stack.push(node.val);
            node = node.next;
        }
    }
}