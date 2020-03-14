package app;

public class App {
    public static void main(String[] args) throws Exception {
        ListNode n = new ListNode(1);
        n.next = new ListNode(7);
        n.next.next = new ListNode(5);
        n.next.next.next = new ListNode(1);
        n.next.next.next.next = new ListNode(9);
        n.next.next.next.next.next = new ListNode(2);
        n.next.next.next.next.next.next = new ListNode(5);
        n.next.next.next.next.next.next.next = new ListNode(1);
        // 1,7,5,1,9,2,5,1
        // 2,7,4,3,5

        int[] m = new Solution().nextLargerNodes(n);

        for (int i = 0; i < m.length; i++) {
            System.out.print(m[i] + ", ");
        }
    }
}