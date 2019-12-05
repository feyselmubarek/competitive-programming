package app;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head != null) {
            ListNode prevNode = head;
            ListNode currNode;
            ListNode nextNode;
            ListNode hListNode;

            if (head.next != null) {
                currNode = prevNode.next;
                nextNode = currNode.next;

                prevNode.next = null;

                while (prevNode.val != k) {
                    currNode.next = prevNode;
                    // System.out.println(prevNode.val + " :val");

                    prevNode = currNode;
                    currNode = nextNode;
                    nextNode = nextNode.next;
                }

                hListNode = prevNode;

                while (prevNode.next != null) {
                    System.out.println(prevNode.val + " :val");
                    prevNode = prevNode.next;
                }

                prevNode.next = currNode;

                return hListNode;
            }
        }

        return head;
    }
}