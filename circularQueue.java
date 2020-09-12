import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
/* 
 */      //queue.display();
        System.out.println("Loading data from data.txt");
        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            queue.enQueue(data);
            System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        {
        System.out.println("Displaying the order of traffic signals : ");
        queue.display();
        }
        queue = null;
        System.gc();
    }
}