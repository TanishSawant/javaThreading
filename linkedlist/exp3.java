package linkedlist;

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

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * LinkedList<T> implements LinkedList
 */
class Linked_list implements LinkedList {
    private Node head;

    public Linked_list() {
        this.head = null;
    }

    @Override
    public void insertAtHead(int data) {
        if (this.head == null) {
            this.head = (Node) new Node(data);
            return;
        } else {
            Node temp = this.head;
            this.head = new Node(data);
            this.head.next = temp;
            return;
        }
    }

    @Override
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
    }

    @Override
    public void insertAtGivenLocation(int data, int position) {
        if (position == 0) {
            insertAtHead(data);
            return;
        }
        int pos = 1;
        Node newNode = new Node(data);
        Node cur = this.head;
        try {
            while (cur.next != null && pos < position) {
                pos++;
                cur = cur.next;
            }
            if (cur.next == null) {
                insertAtTail(data);
            } else {
                Node temp = cur.next;
                cur.next = newNode;
                cur.next.next = temp;
            }    
        } catch (Exception e) {
            try {
                throw new Exception("List terminated before insertion position.");
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void insertInSortedList(int data) {
        Node newNode = new Node(data);
        Node cur = this.head;
        int pos = 0;
        while (cur.next != null && cur.data < data) {
            cur = cur.next;
            pos++;
        }
        if (cur.next == null) {
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
            } catch (Exception e) {
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
    public void deleteGivenNode(int data) {
        Node cur = this.head;
        if (this.head == null) {
            try {
                throw new Exception("List is empty.");
            } catch (Exception e) {
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
            } catch (Exception e) {
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
    public void deleteGivenNodeFromSortedList(int data) {
        Node cur = this.head;
        if (this.head == null) {
            try {
                throw new Exception("List is empty.");
            } catch (Exception e) {
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
            } catch (Exception e) {
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

   
        
}

public class exp3 {
    public static void main(String[] args) {
        Linked_list list1 = new Linked_list();
        list1.insertAtHead(2);
        list1.insertAtHead(1);
        list1.insertAtTail(3);
        list1.insertAtTail(5);
        list1.insertAtTail(6);
        list1.insertAtTail(7);
        list1.insertAtTail(8);
        list1.insertInSortedList(4);
        //list1.insertInSortedList(4);
        list1.deleteGivenNodeFromSortedList(4);
        list1.PrintList();
    }
}
