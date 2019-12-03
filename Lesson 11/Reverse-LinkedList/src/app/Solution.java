package app;

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prevNode = head;
        ListNode currNode;
        ListNode nextNode;

        if (head.next != null) {
            currNode = prevNode.next;
            nextNode = currNode.next;

            prevNode.next = null;

            while (nextNode != null) {
                currNode.next = prevNode;

                prevNode = currNode;
                currNode = nextNode;
                nextNode = nextNode.next;
            }

            currNode.next = prevNode;

            return currNode;
        }

        return head;
    }
}