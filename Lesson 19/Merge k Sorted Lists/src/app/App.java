package app;

import java.util.Comparator;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new NodeComaprator());

        for (ListNode listNode : lists) {
            ListNode node = listNode;

            while (node != null) {
                minHeap.add(new ListNode(node.val));
                node = node.next;
            }
        }

        ListNode head = minHeap.isEmpty() ? null : minHeap.poll();
        ListNode curr = head;

        while (!minHeap.isEmpty()) {
            curr.next = minHeap.poll();
            curr = curr.next;
        }

        return head;
    }
}

class NodeComaprator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode o1, ListNode o2) {
        if (o1.val < o2.val) {
            return -1;
        }

        if (o1.val > o2.val) {
            return 1;
        }

        return 0;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}