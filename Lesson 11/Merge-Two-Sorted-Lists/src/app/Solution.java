package app;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode reslutNode = new ListNode(0);
        ListNode head = reslutNode;

        while (l1 != null && l2 != null) {
            ListNode currentMin;

            if (l1.val > l2.val) {
                currentMin = l2;
                l2 = l2.next;
            } else {
                currentMin = l1;
                l1 = l1.next;
            }
            reslutNode.next = currentMin;
            reslutNode = reslutNode.next;
        }

        if (l1 != null) {
            reslutNode.next = l1;
        } else if (l2 != null) {
            reslutNode.next = l2;
        }

        System.out.println(head.next == null);

        return head.next;
    }
}