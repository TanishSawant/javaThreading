import java.text.MessageFormat;
import java.util.Arrays;


public class Search{


    public static int linearsearch(int[] arr, int x){
        for (int i : arr) {
            if(i == x){
                return 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return 1;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(MessageFormat.format("{0} ", i));
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 23, 6, 0, 12, 1, 42};
        System.out.print("First Array : ");
        printArray(arr);
        System.out.print("\nLinear search for 23 : ");
        System.out.println(linearsearch(arr, 23));
        int[] arr2 = {1, 2,3 ,4 ,5, 6, 7,8};
        System.out.print("Sorted Array : ");
        printArray(arr2);
        System.out.print("\nBinary search for 3 : ");
        System.out.println(binarySearch(arr2, 0, arr.length-1, 2));
    }
}