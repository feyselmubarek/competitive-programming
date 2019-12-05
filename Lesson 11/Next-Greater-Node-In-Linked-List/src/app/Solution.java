package app;

import java.util.ArrayList;

public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode cuurentNode = head;
        boolean isFound = false;

        while (cuurentNode.next != null) {
            int curentTemp = cuurentNode.val;
            ListNode nextNode = cuurentNode.next;
            isFound = false;

            while (nextNode != null) {
                if (curentTemp < nextNode.val) {
                    arrayList.add(nextNode.val);
                    isFound = true;
                    break;
                }
                nextNode = nextNode.next;
            }

            if (!isFound) {
                arrayList.add(0);
            }
            cuurentNode = cuurentNode.next;
        }
        arrayList.add(0);

        return arrayList.stream().mapToInt(i -> i).toArray();
    }
}