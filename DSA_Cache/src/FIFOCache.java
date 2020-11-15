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
                QNode temp = this.queue.rear;
                this.htable.remove(temp.key);
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
    }

    public void printCache(){
        if(this.queue.isEmpty()){
            System.out.println("Cache is Empty");
        }
        else{
            this.queue.printQueue();
        }
    }

    public static void main(String[] args) {
        FIFOCache cache = new FIFOCache(5);
        cache.printCache();
        cache.get(1);
        cache.get(2);
        cache.get(3);
        cache.get(4);
        cache.get(5);
        cache.get(6);
        cache.get(7);
        cache.printCache();
    }
}