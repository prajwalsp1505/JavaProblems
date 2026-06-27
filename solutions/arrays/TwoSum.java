/**
 * Problem: Two Sum
 * Difficulty: Easy ⭐
 * 
 * Problem Statement:
 * Given an array of integers nums and an integer target, return the indices of the two numbers
 * such that they add up to target. You may assume that each input has exactly one solution,
 * and you may not use the same element twice.
 * 
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] == 9, so we return [0, 1].
 * 
 * Constraints:
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum {
    
    /**
     * APPROACH 1: Hash Map (Recommended)
     * Time: O(n), Space: O(n)
     * 
     * Idea:
     * - Use a hash map to store value -> index
     * - For each number, check if (target - number) exists in map
     * - If yes, return the indices
     * - If no, add current number to map
     */
    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if complement exists in map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            // Add current number to map
            map.put(nums[i], i);
        }
        
        return new int[]{-1, -1}; // No solution found
    }
    
    /**
     * APPROACH 2: Brute Force (Not recommended)
     * Time: O(n^2), Space: O(1)
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    
    /**
     * APPROACH 3: Two Pointer (Works only for sorted array)
     * Time: O(n log n), Space: O(1)
     */
    public static int[] twoSumTwoPointer(int[] nums, int target) {
        // Need to sort and track original indices
        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }
        
        // Sort by values
        Arrays.sort(indices, (a, b) -> Integer.compare(nums[a], nums[b]));
        
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[indices[left]] + nums[indices[right]];
            if (sum == target) {
                return new int[]{indices[left], indices[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[]{-1, -1};
    }
    
    public static void main(String[] args) {
        System.out.println("=== Two Sum ===");
        
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Input: " + Arrays.toString(nums1) + ", Target: " + target1);
        System.out.println("Output: " + Arrays.toString(twoSumHashMap(nums1, target1)));
        System.out.println();
        
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Input: " + Arrays.toString(nums2) + ", Target: " + target2);
        System.out.println("Output: " + Arrays.toString(twoSumHashMap(nums2, target2)));
        System.out.println();
        
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("Input: " + Arrays.toString(nums3) + ", Target: " + target3);
        System.out.println("Output: " + Arrays.toString(twoSumHashMap(nums3, target3)));
    }
}
