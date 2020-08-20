/**
 * quicksort
 */
public class quicksort {
    public static int[] quickSort(int l, int h, int[] arr) {
        int j = partition(arr, l, h);
        quickSort(l, j, arr);
        quickSort(j+1, h, arr);
        return arr;
    }

    public static int partition(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l;
        int j = h;
        
        while (i<=j) {
            do{
                i++;
            }while(arr[i] <= pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            
            if (i<j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;    
            }
        }
        int temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void main(String[] args) {
        int a[] = {5, 1, 3, 9, 4, 11, 95, 43, 54, 66};
        int[] result = quickSort(0, a.length-1, a);
        for (int i : result) {
            System.out.println(i + " ");
        }
    }
}