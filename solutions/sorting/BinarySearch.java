/**
 * Problem: Binary Search
 * Difficulty: Easy ⭐
 * 
 * Problem Statement:
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - -10^4 < nums[i], target < 10^4
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

public class BinarySearch {
    
    /**
     * APPROACH 1: Iterative (Recommended)
     * Time: O(log n), Space: O(1)
     */
    public static int searchIterative(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        
        return -1; // Not found
    }
    
    /**
     * APPROACH 2: Recursive
     * Time: O(log n), Space: O(log n) - recursion stack
     */
    public static int searchRecursive(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length - 1);
    }
    
    private static int searchHelper(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        
        int mid = left + (right - left) / 2;
        
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return searchHelper(nums, target, mid + 1, right);
        } else {
            return searchHelper(nums, target, left, mid - 1);
        }
    }
    
    /**
     * APPROACH 3: Find First Occurrence
     */
    public static int searchFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    /**
     * APPROACH 4: Find Last Occurrence
     */
    public static int searchLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Binary Search ===");
        
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        System.out.println("Input: " + Arrays.toString(nums1) + ", Target: " + target1);
        System.out.println("Output: " + searchIterative(nums1, target1));
        System.out.println();
        
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 13;
        System.out.println("Input: " + Arrays.toString(nums2) + ", Target: " + target2);
        System.out.println("Output: " + searchIterative(nums2, target2));
    }
}
