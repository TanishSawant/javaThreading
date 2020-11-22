public class FIFOCache implements Cache {

    private QuadraticProbingHashTable htable;
    private Queue queue;

    FIFOCache(int capacity) {
        this.queue = new Queue();
        this.htable = new QuadraticProbingHashTable(capacity);
    }

    @Override
    public int get(int key) {
        if (this.htable.contains(key)) {
            return key;
        }
        if(!this.htable.contains(key)){
            if(this.htable.isFull()){
                QNode temp = this.queue.front;
                this.htable.remove(temp.key);
                this.htable.insert(key);
                this.queue.dequeue();
                this.queue.enqueue(key);
            }
            else{
                this.htable.insert(key);
                this.queue.enqueue(key);
            }
        }
        return key;
    }

    @Override
    public void clear() {
        this.queue.destroy();
        this.htable.makeEmpty();
        System.out.println("FIFO Cache has been emptied.");
    }

    public void printCache(){
        if(this.queue.isEmpty()){
            System.out.println("FIFO Cache is Empty");
        }
        else{
            System.out.println("\n-----------------------------------------------------------");
            System.out.println("Elements of the FIFO Cache is:");
            this.queue.printQueue();
            System.out.println("\n-----------------------------------------------------------");

        }
    }

    public static void main(String[] args) {
        FIFOCache cache = new FIFOCache(5);
        cache.printCache();
        cache.get(1);
        cache.get(5);
        cache.get(9);
        cache.get(4);
        cache.get(2);
        cache.htable.printHashTable();
        cache.printCache();
        cache.get(6);
        cache.get(7);
        cache.htable.printHashTable();
        cache.printCache();
        cache.clear();
        cache.get(1);
        cache.get(3);
        cache.printCache();
    }
}