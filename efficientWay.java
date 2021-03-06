public class efficientWay {
    public static void main(String[] args) {
        Runnable obj1 = new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Obj1 " + Thread.currentThread().getPriority());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable obj2 = new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Obj2 " + Thread.currentThread().getPriority());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t1 = new Thread(obj1);
        t1.setPriority(1);
        System.out.println(t1.getPriority());
        Thread t2 = new Thread(obj2);
        t2.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t2.getPriority());
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(t1.isAlive());
        System.out.println("Bye!");
    }
}