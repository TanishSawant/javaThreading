import java.lang.reflect.UndeclaredThrowableException;

/**
 * myStack
 */
interface myStack<T> {
    public void push(T itemT);

    public void pop();

    public boolean isEmpty();

    public T getTop();

    public void display();
}

/**
 * StackArray
 */
class StackArray<T> implements myStack<T> {
    private final static int MAX = 100;
    private int top;
    private T[] arr;

    public StackArray() {
        arr = (T[]) new Object[10];
        int top = -1;
    }

    @Override
    public void push(T itemT) {
        if (top == MAX - 1) {
            try {
                throw new Exception("Cannot push item");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            arr[++top] = itemT;
        }
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            try {
                throw new Exception("Underflow....");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            top--;
            System.out.println("Deleted " + arr[top]);
        }

    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return this.top == -1;
    }

    @Override
    public T getTop() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Top Element: " + arr[top]);
        }
        return null;
    }

    @Override
    public void display() {
        for (T t : arr) {
            System.out.println(t);
        }
    }

}

/**
 * StackPointers
 */
class StackPointers<T> implements myStack<T> {

    class Node<T> {
        protected T data;
        protected Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    public StackPointers() {
        top = null;
        size = 0;
    }

    @Override
    public void push(T itemT) {
        Node aNode = new Node(itemT);
        aNode.next = top;
        top = aNode;
    }

    @Override
    public void pop() {
        if (top == null) {
            try {
                throw new Exception("Underflow error....");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            Node temp = top;
            top = top.next;
            System.out.println("Deleted : " + temp.data);
            temp = null;
        }

    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public T getTop() {
        if (isEmpty()) {
            try {
                throw new Exception("No element.....");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        } else {
            System.out.println("Top: "+ top.data);
        }
        return (T) top.data;
    }

    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else {
            Node cur = top;
            while (cur.next != null) {
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
        }

    }

    
}

public class genericStack {
    public static void main(String[] args) {
        /* StackArray<Integer> st1 = new StackArray<Integer>();
        System.out.println("Stack will be initialized with 10 elements...");
        st1.push(5);
        st1.push(9);
        st1.push(3);
        st1.getTop();
        st1.pop();
        st1.display(); */

        StackPointers<Integer> st2 = new StackPointers<Integer>();
        st2.push(5);
        st2.push(1);
        st2.push(7);
        st2.push(4);
        st2.push(0);
        st2.push(8);
        st2.push(2);
        st2.push(9);
        st2.display();
        
        st2.getTop();
        st2.pop();
        st2.getTop();

        System.gc();
    }
}