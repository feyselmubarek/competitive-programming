package app;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode curNode, prevNode, nextNode;

        if (head != null) {
            prevNode = head;

            if (head.next == null) {
                return head;
            }

            ListNode headHolder = prevNode.next, prevPrevNode = prevNode;

            while (prevNode.next != null) {
                curNode = prevNode.next;
                nextNode = curNode.next;

                // swaping
                curNode.next = prevNode;
                prevNode.next = nextNode;

                if (prevNode != prevPrevNode) {
                    prevPrevNode.next = curNode;
                }

                // moving to next ones
                prevPrevNode = prevNode;
                prevNode = nextNode;

                // check if nextNode is null, since no point in proceeding
                if (nextNode == null) {
                    break;
                }
            }
            return headHolder;
        }

        return head;
    }
}