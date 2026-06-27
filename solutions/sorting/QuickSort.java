/**
 * Problem: Quick Sort
 * Difficulty: Medium 🔶
 * 
 * Problem Statement:
 * Implement quick sort algorithm to sort an array in ascending order.
 * 
 * Time Complexity: O(n log n) average, O(n^2) worst case
 * Space Complexity: O(log n) - recursion stack
 */

import java.util.Arrays;

public class QuickSort {
    
    /**
     * Main quick sort function
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        quickSort(arr, 0, arr.length - 1);
    }
    
    /**
     * Quick sort with partition
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition and get pivot index
            int pi = partition(arr, low, high);
            
            // Sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    /**
     * Partition using last element as pivot
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Swap arr[i+1] and arr[high]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    /**
     * Alternative partition using first element as pivot
     */
    private static int partitionFirst(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;
        
        while (i <= j) {
            while (i <= j && arr[i] <= pivot) i++;
            while (i <= j && arr[j] > pivot) j--;
            
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        
        return j;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Quick Sort ===");
        
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original: " + Arrays.toString(arr1));
        quickSort(arr1);
        System.out.println("Sorted: " + Arrays.toString(arr1));
        System.out.println();
        
        int[] arr2 = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original: " + Arrays.toString(arr2));
        quickSort(arr2);
        System.out.println("Sorted: " + Arrays.toString(arr2));
        System.out.println();
        
        int[] arr3 = {5, 2, 8, 1, 9};
        System.out.println("Original: " + Arrays.toString(arr3));
        quickSort(arr3);
        System.out.println("Sorted: " + Arrays.toString(arr3));
    }
}
