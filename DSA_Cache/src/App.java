import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of the cache - ");  
        int len = scan.nextInt();
        FIFOCache fcache = new FIFOCache(len);
        LRUCache lrucache = new LRUCache(len);
        char ch;
        do
        {
            System.out.println("\nCache Operations");
            System.out.println("1. get ");
            System.out.println("2. clear");
            System.out.println("3. print");  
            System.out.print("Your Choice: ");          
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.print("\nEnter value: ");
                int value = scan.nextInt();
                fcache.get(value);
                lrucache.get(value); 
                break;                          
            case 2 : 
                System.out.println();                
                fcache.clear();
                lrucache.clear();
                break;                        
            case 3 : 
                fcache.printCache();
                lrucache.printCache();
                break;                                          
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /* Display hash table */
            
            System.out.print("\nDo you want to continue (Type y or n): ");
            ch = scan.next().charAt(0);       
        } while (ch == 'Y'|| ch == 'y');
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