import java.text.MessageFormat;
import java.util.Scanner;

class QuadraticProbingHashTable
{    
    private int currentSize, maxSize;
    private int[] vals;    
    
    public QuadraticProbingHashTable(int capacity) 
    {
        currentSize = 0;
        maxSize = capacity;
        vals = new int[maxSize];
        for(int i = 0; i < vals.length; i++){
            vals[i] = Integer.MIN_VALUE;
        }
        
    }  
 
    public void makeEmpty()
    {
        currentSize = 0;
        vals = new int[maxSize];
    }

    public int getSize() 
    {
        return currentSize;
    }
 
    public boolean isFull() 
    {
        return currentSize == maxSize;
    }
 
    public boolean isEmpty() 
    {
        return getSize() == 0;
    }
 
    public boolean contains(int val) 
    {
        return get(val) !=  Integer.MIN_VALUE;
    }
 
    private int hash(int key) 
    {
        return key % maxSize;
    }

    public void insert(int val) 
    {
        //System.out.println(Integer.MIN_VALUE);
        int tmp = hash(val);
        int i = tmp, h = 1;
        if(vals[i] == Integer.MIN_VALUE){
            vals[i] = val;
            return;
        }
        i = i + 1;
        while (i != tmp)
        {
            if (vals[i] == Integer.MIN_VALUE)
            {
                vals[i] = val;
                currentSize++;
                return;
            }
            i = (tmp + h * h) % maxSize; 
            h++;    
        }
    }
 
    public int get(int val) 
    {
        int i = hash(val), h = 1;
        while (vals[i] != Integer.MIN_VALUE)
        {
            if (vals[i] == val){
                System.out.println(MessageFormat.format("{0} found at Location {1}", vals[i], i));
                return vals[i];
            }
            i = (i + h * h++) % maxSize;
            //System.out.println("i "+ i);
        }
        return Integer.MIN_VALUE;
    }

   public void remove(int val)
    {
        if (!contains(val))
            return;

        int i = hash(val);
        int h = 1;
        while (val != vals[i])
            i = (i + h * h++) % maxSize;
        vals[i] = Integer.MIN_VALUE;
        
        for (i = (i + h * h++) % maxSize; vals[i] != Integer.MIN_VALUE; i = (i + h * h++) % maxSize)
        {
            int tmp2 = vals[i];
            vals[i] = Integer.MIN_VALUE;
            currentSize--;
            insert(tmp2);
        }
        currentSize--;
    }
 
    public void printHashTable()
    {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (vals[i] != Integer.MIN_VALUE)
                System.out.println(vals[i]);
        System.out.println();
    }


}

public class QuadraticProbing
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size");
        QuadraticProbingHashTable qpht = new QuadraticProbingHashTable(scan.nextInt());
        qpht.printHashTable();
        char ch;
        do
        {
            System.out.println("\nHash Table Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. get");            
            System.out.println("4. clear");
            System.out.println("5. size");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter value");
                qpht.insert(scan.nextInt()); 
                break;                          
            case 2 :                 
                System.out.println("Enter value");
                qpht.remove(scan.nextInt()); 
                break;                        
            case 3 : 
                System.out.println("Enter value");
                System.out.println("Value = "+ qpht.get(scan.nextInt()));
                break;                                   
            case 4 : 
                qpht.makeEmpty();
                System.out.println("Hash Table Cleared\n");
                break;
            case 5 : 
                System.out.println("Size = "+ qpht.getSize() );
                break;         
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /** Display hash table **/
            qpht.printHashTable();  
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);       
        } while (ch == 'Y'|| ch == 'y');  
        scan.close();
        qpht = null;
    }
}