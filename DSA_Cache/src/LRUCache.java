import java.text.MessageFormat;

interface Cache {
    public int get(int key);
    public void clear();
}

public class LRUCache implements Cache{
    private dlinkedList dlist;
    private int size;
    private QuadraticProbingHashTable htable;

    LRUCache(int capacity) {
        this.dlist = new dlinkedList();
        this.htable = new QuadraticProbingHashTable(capacity);
    }

    @Override
    public int get(int key) {
        if (htable.contains(key)) {
            //move to the front
        } else {
            if (!htable.isFull()) {
                //Add to the front
            } else {
                //remove rear element and add new page to the front
            }
        }
        return 0;
    }

    @Override
    public void clear(){
        this.dlist = null;
        this.htable = null;
    }

    public void printCache(){
        if (this.dlist.head == null) {
            System.out.println("Cache is empty!");
            return;
        }
        Node cur = this.dlist.head;
        System.out.println("-------------------------------------------------------------");
        while (cur.rNode != null) {
            System.out.print(MessageFormat.format("{0} :: ", cur.data));
        }
        System.out.println("--------------------------------------------------------------");
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.printCache();
    }
}