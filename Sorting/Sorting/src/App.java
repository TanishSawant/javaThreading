import java.text.MessageFormat;

public class App {
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
        int key = array[i];
        int j = i - 1;
        while (j >= 0 && key < array[j]) {
            array[j + 1] = array[j];
            --j;
        }
        array[j + 1] = key;
        }
    }
    
    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(MessageFormat.format("{0}  ", i));
        }
    }

    public static void selectionSort(int[] array) {
        for (int step = 0; step < array.length - 1; step++) {
        int min_idx = step;
        for (int i = step + 1; i < array.length; i++) {
            if (array[i] < array[min_idx]) {
            min_idx = i;
            }
        }
        int temp = array[step];
        array[step] = array[min_idx];
        array[min_idx] = temp;
        }
    }
    private static void maxHeapify(int[] heap, int n, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int max_position = i;
        if (l < n && heap[max_position] < heap[l]) {
            max_position = l;
        }
        if (r < n && heap[max_position] < heap[r]) {
            max_position = r;
        }
        if (max_position != i) {
            swap(heap, i, max_position);
            maxHeapify(heap, n, max_position);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < array.length; i++) {
            maxHeapify(array, n, i);
        }   
        for (int i = n-1; i > 0; i--) {
            swap(array, 0, i);
            maxHeapify(array, i, 0);
        }
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {9, 8, 7, 6, 5, 4, 3 ,2, 1, 0};
        System.out.print("Original Array : ");
        printArray(arr);
        System.out.println();
        insertionSort(arr);
        System.out.print("After insertion sort : ");
        printArray(arr);
        System.out.println();
        int[] arr1 = {19, 18, 17, 16, 15, 14, 13, 12, 11, 10};
        System.out.print("Second array : ");
        printArray(arr1);
        System.out.println();
        selectionSort(arr1);
        System.out.print("After Selection sort on second array : ");
        printArray(arr1);
        System.out.println();
        int[] arr2 = {19, 18, 17, 16, 15, 14, 13, 12, 11, 10};
        System.out.print("Array 3 : ");
        printArray(arr2);
        heapSort(arr2);
        System.out.println();
        System.out.print("After heap sort on third array : ");
        printArray(arr2);
    }
}
