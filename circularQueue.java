import java.text.MessageFormat;
import java.util.Scanner;

/**
 * CircularQueue
 */
interface mycircularQueue<T> {

    public void enQueue(T data);

    public T deQueue();

    public void display();

    public boolean isEmpty();
}

public class circularQueue<T> implements mycircularQueue {
    public circularQueue(){
        this.front = null;
        this.rear = null;
    }
    class QueueNode<T> {
        public QueueNode(T data2) {
            this.data = data2;
        }

        T data;
        QueueNode next;
    }

    private QueueNode front;
    private QueueNode rear;

    @Override
    public void enQueue(Object data) {
        QueueNode temp = new QueueNode<T>((T) data);
        if (isEmpty()) {
            this.front = temp;
            this.rear = temp;
        } else {
            this.rear.next = temp;
            this.rear = temp;
            this.rear.next = this.front;
        }
        System.out.println("EnQueue -> " + data);
    }

    @Override
    public Object deQueue() {
        if (isEmpty()) {
            try {
                throw new Exception("UnderFlow!!");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            if (this.front == this.rear) {
                Object value = this.front.data;
                this.front = null;
                this.rear = null; 
                return value;
            } else {
                Object valObject = this.front.data;
                QueueNode temp = this.front;
                this.front = this.front.next;
                this.rear.next = this.front;
                temp = null;
                return valObject;
            }
        }
        return null;
    }

    @Override
    public void display() {
        if (this.front == null) {
            System.out.println("Queue is empty");
        } else {
            System.out.println(this.front.data);
        }
    }

    @Override
    public boolean isEmpty() {
        if (this.front == null && this.rear == null) {
            return true;
        } else {
            return false;
        }
    }
    protected void finalize() {
        System.out.println("Garbage collector called!!");
    }

    public static void main(String[] args) {
        circularQueue <String> queue = new circularQueue<String>();
/*         queue.display();
        queue.enQueue(5);
        queue.enQueue(9);
        queue.enQueue(6);
        queue.enQueue(3);
        queue.enQueue(8);
        queue.enQueue(2);
        queue.enQueue(1);
        queue.enQueue(0);
        queue.display();
        queue.deQueue();
 */        queue.display();

        System.out.println("-------------------------Menu----------------------------");
        System.out.println("Add operation signal         : 1");
        System.out.println("Remove operation signal      : 2");
        System.out.println("Display all signal statements: 3");
        System.out.println("Quit                         : 4");
        System.out.println("---------------------------------------------------------");
        System.out.print("Enter your choice : ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        while (choice != "4") {
            int counter = 0;
            System.out.println("Enter next Operation : ");
            Scanner sc2 = new Scanner(System.in);
            switch (sc.nextLine()) {
                case "1":
                    System.out.println("Enter the operation signal : ");
                    String op = sc2.nextLine();
                    queue.enQueue(op);
                    counter++;
                    break;
                case "2":
                    System.out.println(MessageFormat.format("Deleted {0} ", queue.front));
                    queue.deQueue();
                    counter++;
                    break;
                case "3":
                    queue.display();
                    counter++;
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.err.println("Wrong Input.");
                    break;
            }
        }
        queue = null;
        System.gc();
    }
}