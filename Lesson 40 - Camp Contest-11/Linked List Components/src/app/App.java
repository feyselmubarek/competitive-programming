package app;

import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> connectedSet = new HashSet<>();

        for (int node : G) {
            connectedSet.add(node);
        }

        ListNode curr = head;
        int conCount = 0;
        boolean lastIncluded = false;

        while (curr != null) {
            int current = curr.val;

            if (connectedSet.contains(current)) {
                if (!lastIncluded) {
                    lastIncluded = true;
                    conCount++;
                }
            } else {
                lastIncluded = false;
            }

            curr = curr.next;
        }

        return conCount;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}