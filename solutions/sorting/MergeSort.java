/**
 * Problem: Merge Sort
 * Difficulty: Medium 🔶
 * 
 * Problem Statement:
 * Implement merge sort algorithm to sort an array in ascending order.
 * 
 * Time Complexity: O(n log n) - always
 * Space Complexity: O(n) - for auxiliary arrays
 */

import java.util.Arrays;

public class MergeSort {
    
    /**
     * Main merge sort function
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        mergeSort(arr, 0, arr.length - 1);
    }
    
    /**
     * Divide the array into halves and sort recursively
     */
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // Sort left half
            mergeSort(arr, left, mid);
            
            // Sort right half
            mergeSort(arr, mid + 1, right);
            
            // Merge both halves
            merge(arr, left, mid, right);
        }
    }
    
    /**
     * Merge two sorted subarrays
     * Combines arr[left..mid] and arr[mid+1..right]
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // Create temporary arrays
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];
        
        // Copy data to temporary arrays
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }
        
        // Merge the temporary arrays back
        int i = 0;      // Left array index
        int j = 0;      // Right array index
        int k = left;   // Main array index
        
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        
        // Copy remaining elements from left array
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        
        // Copy remaining elements from right array
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Merge Sort ===");
        
        int[] arr1 = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original: " + Arrays.toString(arr1));
        mergeSort(arr1);
        System.out.println("Sorted: " + Arrays.toString(arr1));
        System.out.println();
        
        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original: " + Arrays.toString(arr2));
        mergeSort(arr2);
        System.out.println("Sorted: " + Arrays.toString(arr2));
        System.out.println();
        
        int[] arr3 = {5, 2, 8, 1, 9};
        System.out.println("Original: " + Arrays.toString(arr3));
        mergeSort(arr3);
        System.out.println("Sorted: " + Arrays.toString(arr3));
    }
}
