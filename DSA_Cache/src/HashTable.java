// Java program to demonstrate implementation of our 
// own hash table with chaining for collision detection 
import java.util.ArrayList;
import java.util.Hashtable; 
  
// A node of chains 
class HashNode<V> 
{ 
    V value; 
  
    // Reference to next node 
    HashNode<V> next; 
  
    // Constructor 
    public HashNode(V value) 
    {
        this.value = value; 
    }
} 
  


// Class to represent entire hash table 
public class HashTable<V> 
{ 
    // bucketArray is used to store array of chains 
    private ArrayList<HashNode<V>> bucketArray; 
  
    // Current capacity of array list 
    private int numBuckets; 
  
    // Current size of array list 
    private int size; 
  
    // Constructor (Initializes capacity, size and 
    // empty chains. 
    public HashTable() 
    { 
        bucketArray = new ArrayList<>(); 
        numBuckets = 10; 
        size = 0; 
  
        // Create empty chains 
        for (int i = 0; i < numBuckets; i++) 
            bucketArray.add(null); 
    } 
  
    public int size() { return size; } 
    public boolean isEmpty() { return size() == 0; } 
  
    // This implements hash function to find index 
    // for a key 
    private int getBucketIndex(V key) 
    { 
        int hashCode = key.hashCode(); 
        int index = hashCode % numBuckets; 
        return index;
    } 

    public void makeEmpty(){
        bucketArray.clear();
    }

    public boolean isFull(int capacity){
        if (this.size == capacity) {
            return true;
        }
        
        return false;
    }

    public boolean contains(V value){
        int bucketIndex = getBucketIndex(value); 
        HashNode<V> head = bucketArray.get(bucketIndex); 
        HashNode<V> prev = null; 
        while (head != null)
        { 
            // If Key found 
            if (head.value.equals(value)) 
                return true; 
        }
        return false;
    }
  
    // Method to remove a given key 
    public V remove(V key) 
    { 
        // Apply hash function to find index for given key 
        int bucketIndex = getBucketIndex(key); 
  
        // Get head of chain 
        HashNode<V> head = bucketArray.get(bucketIndex); 
  
        // Search for key in its chain 
        HashNode<V> prev = null; 
        while (head != null) 
        { 
            // If Key found 
            if (head.value.equals(key)) 
                break; 
  
            // Else keep moving in chain 
            prev = head; 
            head = head.next; 
        } 
  
        // If key was not there 
        if (head == null) 
            return null; 
  
        // Reduce size 
        size--; 
  
        // Remove key 
        if (prev != null) 
            prev.next = head.next; 
        else
            bucketArray.set(bucketIndex, head.next); 
  
        return head.value; 
    } 
  
    // Returns value for a key 
    public V get(V key) 
    { 
        // Find head of chain for given key 
        int bucketIndex = getBucketIndex(key); 
        HashNode<V> head = bucketArray.get(bucketIndex); 
  
        // Search key in chain 
        while (head != null) 
        { 
            if (head.value.equals(key)) 
                return head.value; 
            head = head.next; 
        } 
  
        // If key not found 
        return null; 
    } 
  
    // Adds a key value pair to hash 
    public void add(V value) 
    { 
        // Find head of chain for given key 
        int bucketIndex = getBucketIndex(value); 
        HashNode<V> head = bucketArray.get(bucketIndex); 
  
        // Check if key is already present 
        while (head != null) 
        { 
            if (head.value.equals(value)) 
            { 
                head.value = value; 
                return; 
            } 
            head = head.next; 
        } 
  
        // Insert key in chain 
        size++; 
        head = bucketArray.get(bucketIndex); 
        HashNode<V> newNode = new HashNode<V>(value); 
        newNode.next = head; 
        bucketArray.set(bucketIndex, newNode); 
  
        // If load factor goes beyond threshold, then 
        // double hash table size 
        if ((1.0*size)/numBuckets >= 0.7) 
        { 
            ArrayList<HashNode<V>> temp = bucketArray; 
            bucketArray = new ArrayList<>(); 
            numBuckets = 2 * numBuckets; 
            size = 0; 
            for (int i = 0; i < numBuckets; i++) 
                bucketArray.add(null); 
  
            for (HashNode<V> headNode : temp) 
            { 
                while (headNode != null) 
                { 
                    add(headNode.value); 
                    headNode = headNode.next; 
                }
            } 
        } 
    } 
  
    // Driver method to test Map class 
    public static void main(String[] args) 
    { 
        HashTable<Integer>map = new HashTable<>(); 
        map.add(1); 
        map.add(2); 
        map.add(4 ); 
        map.add(5 ); 
        System.out.println(map.size()); 
        System.out.println(map.remove(1));  
        System.out.println(map.size()); 
        System.out.println(map.isEmpty()); 
    } 
} 
