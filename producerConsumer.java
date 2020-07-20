/**
 * A
 */
class A {
    int num;
    boolean setVal = false;

    public synchronized void setNum(int n) throws InterruptedException {
        while (setVal) {
            wait();
        }
        this.num = n;
        System.out.println("Set : " + this.num);
        setVal = true;
        notify();
    }

    public synchronized void getNum() throws InterruptedException {
        while (!setVal) {
            wait();
        }
        System.out.println("Get : " + this.num);
        setVal = false;
        notify();
    }

}

/**
 * Producer
 */
class Producer implements Runnable {
    A a;

    public Producer(A a) {
        this.a = a;
        Thread t = new Thread(this, "producer");
        t.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            try {
                a.setNum(i++);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

/**
 * Consumer
 */
class Consumer implements Runnable {
    A a;

    public Consumer(A a) {
        this.a = a;
        Thread t = new Thread(this, "consumer");
        t.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            try {
                a.getNum();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}

public class producerConsumer {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        new Producer(a);
        new Consumer(a);
        Thread.sleep(10000);
    }
}