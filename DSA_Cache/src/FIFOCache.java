public class FIFOCache implements Cache {

    //private HashTable htable;
    private HashTable<Integer> htable;
    private Queue queue;
    private int capacity = 0;

    FIFOCache(int capacity) {
        this.queue = new Queue();   
        this.htable = new HashTable<Integer>();
        this.capacity = capacity;
    }

    @Override
    public int get(int key) {
        if (this.htable.contains(key)) {
            return key;
        }
        if(!this.htable.contains(key)){
            if(this.htable.isFull(capacity)){
                QNode temp = this.queue.front;
                this.htable.remove(temp.key);
                this.htable.add(key);
                this.queue.dequeue();
                this.queue.enqueue(key);
            }
            else{
                this.htable.add(key);
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
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FIFOCache cache = new FIFOCache(10);
        cache.printCache();
        cache.get(1);
        cache.get(5);
        cache.get(9);
        cache.get(4);
        cache.get(2);
        cache.get(4);
        cache.get(7);
        cache.get(19);
        cache.get(33);
        cache.get(12);
        cache.get(123);
        cache.get(43);
        cache.get(57);
        cache.printCache();
    }
}