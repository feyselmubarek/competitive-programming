package app;

public class App {
    public static void main(String[] args) throws Exception {
        ListNode listNode = new ListNode(1);
        // listNode.next = new ListNode(2);
        // listNode.next.next = new ListNode(3);
        // listNode.next.next.next = new ListNode(3);
        // listNode.next.next.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode h = new Solution().deleteDuplicates(listNode);

        System.out.println();
        while (h != null) {
            System.out.print(h.val + ", ");
            h = h.next;
        }
        System.out.println();
    }
}