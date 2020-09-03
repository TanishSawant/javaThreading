/**
 * queueList
 */
public class queueList<T> {
    /**
     * QueueNode
     */
    class QueueNode<T> {
        T data;
        QueueNode next;

        public QueueNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private QueueNode frontNode;
    private QueueNode rearNode;

    public boolean isEmpty() {
        return frontNode == null && rearNode == null;
    }

    public void enqueue(T data) {
        QueueNode newNode = new QueueNode<T>(data);
        if (isEmpty()) {
            frontNode = newNode;
            rearNode = newNode;
        } else {
            rearNode.next = newNode;
            rearNode = newNode;
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            try {
                throw new Exception("Queue is empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            frontNode = frontNode.next;
        }
    }

    public T peek() {
        System.out.println("Peek");
        return (T) frontNode.data;
    }

    public static void main(String[] args) {
        queueList <Integer> queue1 = new queueList<Integer>();
        int[] list = {4, 2, 8, 44, 9, 6, 0};
        for (int i : list) {
            queue1.enqueue(i);
        }
        int d = queue1.peek();
        System.out.println(d);
        queue1.dequeue();
        System.out.println(queue1.peek());
        for (int i = 0; i < 5; i++) {
            queue1.dequeue();
           System.out.println(queue1.peek());
        }
        queue1 = null;
        System.gc();
    }
}