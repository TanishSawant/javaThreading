

/**
 * Node
 */
class Node {
    int data;
    Node rNode;
    Node lNode;
    
    public Node(int data) {
        this.data = data;
    }
}

public class dlinkedList {
    Node head, tail = null;
    boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }

    void destroy(){
        while (!this.isEmpty()) {
            this.removeLast();
        }
    }

    void addNode(int d){
        Node newNode = new Node(d);
        if (this.head == null && this.tail == null) {
            this.head = this.tail = newNode;
            this.head.lNode = null;
            this.tail.rNode = null;
        } else {
            this.tail.rNode = newNode;
            newNode.lNode = this.tail;
            this.tail = newNode;
        }
    }


    void prepend(int d){
        if (this.head == null) {
           this.head = new Node(d);
           this.tail = this.head;
           return;
        }
        Node newNode = new Node(d);
        newNode.rNode = this.head;
        this.head.lNode = newNode;
        this.head = newNode;
    }


    void displayNodes(){
        Node currentNode = this.head;
        if (this.head == null) {
            System.out.println("List is empty!");
            return;
        } else {
            System.out.println("Printing nodes.......");
            while (currentNode != null) {
                System.out.print(currentNode.data + ", ");
                currentNode = currentNode.rNode;
            }
        }
    }
    void displayNodesRev(){
        Node currentNode = this.tail;
        if (this.head == null) {
            System.out.println("List is empty!");
            return;
        } else {
            System.out.println("Printing nodes Reversed.......");
            while (currentNode != null) {
                System.out.print(currentNode.data + ", ");
                currentNode = currentNode.lNode;
            }
        }
    }
    void reverseList(){
        Node temp = null;
        Node cur = this.head;
        while (cur != null) {
            temp = cur.lNode;
            cur.lNode = cur.rNode;
            cur.rNode = temp;
            cur = cur.lNode;
        }
        if (temp != null) {
            this.head = temp.lNode;
        }
    }

    public void removeLast(){
        if (head == null) {
            return;
        }
        Node temp = this.tail;
        this.tail = this.tail.lNode;
        if(temp == head) head = null;
        temp = null;
    }

    public void removeGivenElement(int key){
        Node temp = this.head;
        if (this.tail.data == key) {
            this.removeGivenNode(this.tail);
            return;
        }
        while(temp.rNode != null){
            if(temp.data == key){
                this.removeGivenNode(temp);
            }
            temp = temp.rNode;
        }
    }

    void removeGivenNode(Node del)
    {
        if (head == null || del == null)
            return;

        if (head == del) 
            head = del.rNode;

        if (del.rNode != null) 
            del.rNode.lNode = del.lNode;

        if (del.lNode != null) 
            del.lNode.rNode = del.rNode;

        return;
    }
    public static void main(String[] args) {
        dlinkedList list1 = new dlinkedList();
        list1.displayNodes();
        list1.addNode(5);
        list1.addNode(2);
        list1.addNode(8);
        list1.addNode(1);
        list1.addNode(6);
        list1.addNode(3);
        list1.addNode(0);
        list1.addNode(4);
        list1.displayNodes();
        list1.displayNodesRev();
        list1.reverseList();
        list1.displayNodes();
    }
}