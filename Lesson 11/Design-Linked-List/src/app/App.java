package app;

public class App {
    public static void main(String[] args) throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addAtHead(82);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(39);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtTail(67);
        myLinkedList.addAtIndex(3, 30);
        myLinkedList.printNodes();
        // myLinkedList.printNodes();

        // myLinkedList.deleteAtIndex(5);
        // myLinkedList.addAtTail(90);
        // myLinkedList.addAtHead(90);

        // myLinkedList.deleteAtIndex(5);
        // myLinkedList.printNodes();
        // myLinkedList.deleteAtIndex(6);
        // myLinkedList.deleteAtIndex(6);
        // myLinkedList.deleteAtIndex(6);
        // myLinkedList.deleteAtIndex(0);
        // myLinkedList.deleteAtIndex(0);
        myLinkedList.addAtIndex(-1, 56);

        myLinkedList.deleteAtIndex(0);
        myLinkedList.printNodes();

        myLinkedList.deleteAtIndex(5);
        myLinkedList.printNodes();

        // myLinkedList.deleteAtIndex(0);
        myLinkedList.addAtHead(100);
        myLinkedList.addAtIndex(0, 200);

        myLinkedList.printNodes();

        System.out.println("indx -1 => " + myLinkedList.get(-1));
        // System.out.println("indx 6 => " + myLinkedList.get(6));
        // System.out.println(myLinkedList.get(2));
        // System.out.println(myLinkedList.get(3));
        // System.out.println(myLinkedList.get(4));
        // System.out.println(myLinkedList.get(5));
        // System.out.println(myLinkedList.get(6));
    }
}