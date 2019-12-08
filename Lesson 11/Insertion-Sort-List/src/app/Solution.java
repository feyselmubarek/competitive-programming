package app;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else {
            ListNode currentNodec = head;
            ListNode headerNode = head;
            ListNode checkerNode = currentNodec.next;
            ListNode nextNode, prevNode = currentNodec;
            boolean isInsertion = false;

            while (checkerNode != null) {
                nextNode = checkerNode.next;
                isInsertion = false;
                ListNode prevCurrentNode = currentNodec;

                while (currentNodec != checkerNode && checkerNode != null) {
                    if (currentNodec.val > checkerNode.val) {
                        if (currentNodec == headerNode) {
                            headerNode = checkerNode;
                            checkerNode.next = currentNodec;
                            prevNode.next = nextNode;
                        } else {
                            checkerNode.next = currentNodec;
                            prevNode.next = nextNode;
                            prevCurrentNode.next = checkerNode;
                        }
                        isInsertion = true;
                        break;
                    }
                    prevCurrentNode = currentNodec;
                    currentNodec = currentNodec.next;
                }
                currentNodec = headerNode;
                if (!isInsertion) {
                    prevNode = checkerNode;
                    isInsertion = false;
                }
                checkerNode = nextNode;
            }
            return headerNode;
        }

    }
}