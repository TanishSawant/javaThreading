package linkedlist;

import java.text.MessageFormat;

/**
 * LinkedList
 */
interface LinkedList {
    public void insertAtHead(int data);

    public void insertAtTail(int data);

    public void insertAtGivenLocation(int data, int position);

    public void insertInSortedList(int data);

    public void deleteFirstNode();

    public void deleteLastNode();

    public void deleteGivenNode(int data);

    public void deleteGivenNodeFromSortedList(int data);
}

class Node {
    int data;
    Node next;

    public Node(final int data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * LinkedList<T> implements LinkedList
 */
class Linked_list implements LinkedList {
    
    Node head;

    public Linked_list() {
        this.head = null;
    }

    @Override
    public void insertAtHead(final int data) {
        if (this.head == null) {
            this.head = (Node) new Node(data);
            return;
        } else {
            final Node temp = this.head;
            this.head = new Node(data);
            this.head.next = temp;
            return;
        }
    }

    @Override
    public void insertAtTail(final int data) {
        final Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
    }

    @Override
    public void insertAtGivenLocation(final int data, final int position) {
        if (position == 0) {
            insertAtHead(data);
            return;
        }
        int pos = 1;
        final Node newNode = new Node(data);
        Node cur = this.head;
        try {
            while (cur.next != null && pos < position) {
                pos++;
                cur = cur.next;
            }
            if (cur.next == null) {
                insertAtTail(data);
            } else {
                final Node temp = cur.next;
                cur.next = newNode;
                cur.next.next = temp;
            }
        } catch (final Exception e) {
            try {
                throw new Exception("List terminated before insertion position.");
            } catch (final Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void insertInSortedList(final int data) {
        // new Node(data);
        Node cur = this.head;
        int pos = 0;

        if (this.head == null) {
            this.head = new Node(data);
            return;
        }
        while (cur.next != null && cur.data < data) {
            pos++;
            cur = cur.next;
        }
        if (cur == null) {
            insertAtTail(data);
        } else {
            insertAtGivenLocation(data, pos);
        }
    }

    @Override
    public void deleteFirstNode() {
        if (this.head == null) {
            try {
                throw new Exception("List is Empty");
            } catch (final Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            Node temp = this.head;
            this.head = temp.next;
            temp = null;
        }
    }

    @Override
    public void deleteLastNode() {
        Node cur = this.head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        Node temp = (Node) cur.next;
        cur.next = null;
        temp = null;
    }

    @Override
    public void deleteGivenNode(final int data) {
        Node cur = this.head;
        if (this.head == null) {
            try {
                throw new Exception("List is empty.");
            } catch (final Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }
        while (cur.next != null && cur.next.data != data) {
            cur = cur.next;
        }
        if (cur.next == null) {
            try {
                throw new Exception("Node not found!");
            } catch (final Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        } else {
            Node temp = cur.next;
            cur.next = temp.next;
            temp = null;
        }
    }

    @Override
    public void deleteGivenNodeFromSortedList(final int data) {
        Node cur = this.head;
        if (this.head == null) {
            try {
                throw new Exception("List is empty.");
            } catch (final Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }
        while (cur.next != null && cur.next.data < data) {
            cur = cur.next;
        }
        if (cur.next == null) {
            try {
                throw new Exception("Node not found!");
            } catch (final Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        } else {
            Node temp = cur.next;
            cur.next = temp.next;
            temp = null;
        }
    }

    public int lengthOfList() {
        if (this.head == null) {
            return 0;
        } else {
            Node cur = this.head;
            int n = 0;
            while (cur.next != null) {
                cur = cur.next;
                n++;
            }
            return n + 1;
        }
    }

    public Linked_list[] FrontBackSplit() {
        final Linked_list lLinked_list = new Linked_list();
        final Linked_list rLinked_list = new Linked_list();
        final int splitIndex = (this.lengthOfList() + 1) / 2;
        final Linked_list[] arr = { lLinked_list, rLinked_list };
        final int n = this.lengthOfList();
        Node cur = this.head;
        for (int i = 0; i < splitIndex; i++) {
            lLinked_list.insertAtTail(cur.data);
            cur = cur.next;
        }
        for (int i = splitIndex; i < n; i++) {
            rLinked_list.insertAtTail(cur.data);
            cur = cur.next;
        }

        return arr;
    }

    void PrintList() {
        Node node = this.head;
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null)
                System.out.print(",");
        }
        System.out.println();
    }

    public Node mergeLists(Node A, Node B) {
        if (A == null)
            return B;
        if (B == null)
            return A;

        if (A.data < B.data) {
            A.next = mergeLists(A.next, B);
            return A;
        } else {
            B.next = mergeLists(A, B.next);
            return B;
        }
    }

    protected void finalize() {
        System.out.println("GC was called!");
    }
}

public class exp3 {

    protected void finalize() {
        System.out.println("GC is called!");
    }

    public static void main(final String[] args) {
        
        Linked_list list1 = new Linked_list();
        Linked_list[] arr;
        list1.insertAtHead(2);
        list1.insertAtHead(1);
        list1.insertAtTail(3);
        list1.insertAtTail(5);
        list1.insertAtTail(6);
        list1.insertAtTail(7);
        list1.insertAtTail(9);
        list1.insertInSortedList(4);
        list1.insertInSortedList(8);
        System.out.print("List : ");
        list1.PrintList();
        System.out.println(list1.lengthOfList());
        System.out.println("----------------------------------------");
        System.out.println("SubLists : ");
        arr = list1.FrontBackSplit();
        arr[0].PrintList();
        arr[1].PrintList();

        System.out.println("-----------------------------------------");
        System.out.println(MessageFormat.format("Merging {0} and {1}", arr[0], arr[1]));
        System.out.print("Merged list:");

        Node temp = list1.mergeLists(arr[0].head, arr[1].head);
        Linked_list newList = new Linked_list();
        newList.head = temp;
        newList.PrintList();
        //free memory
        newList = null;
        arr = null;
        list1 = null;
        System.gc();
    }
}
