package app;

public class App {
    public static void main(String[] args) throws Exception {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);

        ListNode l = new Solution().reverseKGroup(n, 3);

        System.out.println();
        System.out.println("[ ");
        while (l != null) {
            System.out.print(l.val + ", ");
            l = l.next;
        }
        System.out.println("]");
        System.out.println();
    }
}