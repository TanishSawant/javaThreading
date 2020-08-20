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

public class genericStack {
    public static void main(String[] args) {
        StackArray<Integer> st1 = new StackArray<Integer>();
        System.out.println("Stack will be initialized with 10 elements...");
        st1.push(5);
        st1.push(9);
        st1.push(3);
        st1.getTop();
        st1.pop();
        st1.display();

        System.gc();
    }
}