/**
 * Problem: Container With Most Water
 * Difficulty: Medium 🔶
 * 
 * Problem Statement:
 * You are given an integer array height of length n. There are n vertical lines drawn such that
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * 
 * Example:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The vertical lines are at index 1 and 8. Area = min(8,7) * (8-1) = 7 * 7 = 49
 * 
 * Constraints:
 * - n == height.length
 * - 2 <= n <= 10^5
 * - 0 <= height[i] <= 10^4
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

public class ContainerWithMostWater {
    
    /**
     * APPROACH: Two Pointer (Greedy)
     * Time: O(n), Space: O(1)
     * 
     * Idea:
     * - Start with widest container (leftmost and rightmost)
     * - Calculate area
     * - Move the pointer with smaller height inward
     * - This is because moving the taller pointer inward can only decrease area
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            // Calculate current area
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int area = width * currentHeight;
            
            // Update max area
            maxArea = Math.max(maxArea, area);
            
            // Move pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
    
    /**
     * Brute Force Solution (Not recommended)
     * Time: O(n^2), Space: O(1)
     */
    public static int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, area);
            }
        }
        
        return maxArea;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Container With Most Water ===");
        
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Input: " + Arrays.toString(height1));
        System.out.println("Output: " + maxArea(height1));
        System.out.println();
        
        int[] height2 = {1, 1};
        System.out.println("Input: " + Arrays.toString(height2));
        System.out.println("Output: " + maxArea(height2));
        System.out.println();
        
        int[] height3 = {2, 3, 4, 5, 18, 17, 6};
        System.out.println("Input: " + Arrays.toString(height3));
        System.out.println("Output: " + maxArea(height3));
    }
}
