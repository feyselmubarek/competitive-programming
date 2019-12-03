package app;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode temp = head;

        if (head.next != null) {
            int currVal = temp.val;
            ListNode nextNode = temp.next;

            while (nextNode != null) {
                if (nextNode.val != currVal) {
                    currVal = nextNode.val;
                    temp.next = nextNode;
                    temp = nextNode;
                }
                nextNode = nextNode.next;
            }

            temp.next = nextNode;
        }

        return head;
    }
}