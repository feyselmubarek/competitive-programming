package app;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(0);
        // l1.next = new ListNode(9);
        // l1.next.next = new ListNode(9);
        // l1.next.next.next = new ListNode(9);
        // l1.next.next.next.next = new ListNode(9);
        // l1.next.next.next.next.next = new ListNode(9);

        // ListNode ll1 = l1.next.next.next.next.next;

        // ll1.next = new ListNode(9);
        // ll1.next.next = new ListNode(9);
        // ll1.next.next.next = new ListNode(9);
        // ll1.next.next.next.next = new ListNode(9);
        // ll1.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode node = solution.addTwoNumbers(l1, l2);

        System.out.print("[ ");
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]");
        System.out.println();

    }
}