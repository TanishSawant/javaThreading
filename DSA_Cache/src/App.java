public class App {
    private interface Cache {
        public int get(int key);
        public void remove(int key);
    }
    
    class LRUCache implements Cache{
        dlinkedList dlist = new dlinkedList();
        final int size = 5;

        @Override
        public int get(int key) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public void remove(int key) {
            // TODO Auto-generated method stub

        }
    }
    
    public static void main(String[] args) throws Exception {

    }
}


// Doubly linked list
// remove : O(1)
// hashtable : O(n) => Quadratic probing.
// Three Functions:
// Get
// remove
// 

// 