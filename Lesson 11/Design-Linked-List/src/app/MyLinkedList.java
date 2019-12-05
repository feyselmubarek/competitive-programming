package app;

class MyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is
     * invalid, return -1.
     */
    public int get(int index) {
        if (index < 0) {
            return -1;
        }

        if (head == null || index > size) {
            return -1;
        } else if (index == 0) {
            return head.val;
        } else {
            int ind = 1;
            ListNode prevNode = head;
            ListNode currentNode = prevNode.next;

            while (prevNode.next != null) {
                if (ind == index) {
                    return currentNode.val;
                }

                prevNode = currentNode;
                currentNode = prevNode.next;
                ind++;
            }
        }

        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After
     * the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode(val);
            tail = head;
        } else {
            ListNode node = new ListNode(val);
            node.next = head;
            head = node;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (tail == null) {
            tail = new ListNode(val);
            head = tail;
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index
     * equals to the length of linked list, the node will be appended to the end of
     * linked list. If index is greater than the length, the node will not be
     * inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            int ind = 1;
            ListNode prevNode = head;
            ListNode currentNode = prevNode.next;

            while (prevNode.next != null) {
                if (ind == index) {
                    ListNode node = new ListNode(val);
                    prevNode.next = node;
                    node.next = currentNode;
                    size++;
                    break;
                }

                prevNode = currentNode;
                currentNode = currentNode.next;
                ind++;
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index == 0) {
            if (size == 1 || (head == null && tail == null)) {
                head = null;
                tail = null;
                size = 0;
            } else {
                head = head.next;
            }
            size--;
        } else if (index <= size) {
            int ind = 1;
            ListNode prevNode = head;
            ListNode currentNode = prevNode.next;

            while (prevNode.next != null) {
                if (ind == index) {
                    if (index == (size - 1)) {
                        tail = prevNode;
                        prevNode.next = currentNode.next;
                    } else {
                        prevNode.next = currentNode.next;
                    }
                    size--;
                    break;
                }

                prevNode = currentNode;
                currentNode = currentNode.next;
                ind++;
            }

            // if (ind == index && index <= size) {
            // prevNode.next = currentNode.next;
            // size--;
            // }
        }
    }

    public void printNodes() {
        ListNode prevNode = head;
        ListNode currentNode = prevNode.next;

        System.out.println();
        System.out.print("[ ");
        while (prevNode.next != null) {
            System.out.print(prevNode.val + ", ");
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        System.out.print(prevNode.val + ", ");
        System.out.print("]");
        System.out.println();
    }
}

/**
 * ListNode
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}