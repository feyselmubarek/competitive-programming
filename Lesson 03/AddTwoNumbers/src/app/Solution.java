package app;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode pointer = answer;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int number = l1 != null ? l1.val : 0;
            int number2 = l2 != null ? l2.val : 0;

            int sum = number + number2 + carry;
            carry = 0;

            if (sum > 9) {
                carry = 1;
                sum -= 10;
            }

            answer.next = new ListNode(sum);
            answer = answer.next;

            try {
                l1 = l1.next;
            } catch (Exception e) {
            }

            try {
                l2 = l2.next;
            } catch (Exception e) {

            }
        }

        if (carry > 0) {
            answer.next = new ListNode(1);
        }

        return pointer.next;
    }
}