import java.text.MessageFormat;

interface Cache {
    public int get(int value);
    public void clear();
}

public class LRUCache implements Cache{
    private dlinkedList dlist;
    private QuadraticProbingHashTable htable;

    LRUCache(int capacity) {
        this.dlist = new dlinkedList();
        this.htable = new QuadraticProbingHashTable(capacity);
    }

    @Override
    public int get(int key) {
        if (htable.contains(key)) {
            this.dlist.removeGivenElement(key);
            this.dlist.prepend(key);
        } else {
            if (!htable.isFull()) {
                this.dlist.prepend(key);
                this.htable.insert(key);
            } else {
                Node last = this.dlist.tail;
                this.dlist.removeLast();
                this.htable.remove(last.data);
                this.dlist.prepend(key);
                this.htable.insert(key);
            }
        }
        return key;
    }

    @Override
    public void clear(){
        this.dlist.destroy();
        this.htable.makeEmpty();
    }

    public void printCache(){
        if (this.dlist.head == null) {
            System.out.println("Cache is empty!");
            return;
        }
        Node cur = this.dlist.head;
        System.out.println("-------------------------------------------------------------");
        while (cur != null) {
            System.out.print(MessageFormat.format("{0} :: ", cur.data));
            cur = cur.rNode;
        }
        System.out.println("--------------------------------------------------------------");
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.printCache();
        cache.get(1);
        cache.get(2);
        cache.get(3);
        cache.get(3);
        cache.printCache();
        cache.clear();
        //cache.clear();
        cache.get(4);
        cache.get(5);
        cache.printCache();
        //cache.clear();
    }
}