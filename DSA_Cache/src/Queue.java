class QNode { 
    int key; 
    QNode next; 
  
    // constructor to create a new linked list node 
    public QNode(int key) 
    { 
        this.key = key; 
        this.next = null; 
    }
} 
  
public class Queue { 
    QNode front, rear; 
  
    public Queue() 
    { 
        this.front = this.rear = null; 
    } 
    
    boolean isEmpty(){
        return this.front == null;
    }

    void enqueue(int key) 
    { 
  
        QNode temp = new QNode(key); 
        if (this.rear == null) { 
            this.front = this.rear = temp; 
            return; 
        } 
  
        this.rear.next = temp; 
        this.rear = temp; 
    } 
  
    void dequeue() {
        if (this.front == null) 
            return; 
        QNode temp = this.front; 
        this.front = temp.next; 
        temp = null;
        if (this.front == null) 
            this.rear = null; 
    }

    void destroy(){
        while (!this.isEmpty()) {
            this.dequeue();
        }
    }
    void printQueue(){
        QNode tempfront = this.front;
        while(tempfront != null){
            System.out.print(tempfront.key + " ");
            tempfront = tempfront.next;
        }
    }
    public static void main(String[] args) 
    { 
        Queue q = new Queue(); 
        q.enqueue(10); 
        q.enqueue(20); 
        q.dequeue(); 
        q.dequeue(); 
        q.enqueue(30); 
        q.enqueue(40); 
        q.enqueue(50); 
        q.dequeue(); 
        System.out.println("Queue Front : " + q.front.key); 
        System.out.println("Queue Rear : " + q.rear.key); 
    }
}