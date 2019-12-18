package app;

public class App {
    public static void main(String[] args) throws Exception {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        // l.next.next.next.next = new ListNode(5);

        l = new Solution().swapPairs(l);

        System.out.println();
        while (l != null) {
            System.out.print(l.val + " => ");
            l = l.next;
        }
        System.out.println();
    }
}