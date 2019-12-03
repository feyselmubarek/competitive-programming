package app;

public class App {
    public static void main(String[] args) throws Exception {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        // n.next.next.next = new ListNode(4);
        // n.next.next.next.next = new ListNode(5);

        ListNode node = new Solution().reverseList(n);

        System.out.println();
        System.out.print("[ ");
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
        System.out.print("]");
        System.out.println();

    }
}