package app;

class Solution {
    public void deleteNode(ListNode node) {
        // setting the value of the node to be next node value
        node.val = node.next.val;
        // setting the next value to next next node
        node.next = node.next.next;
    }
}