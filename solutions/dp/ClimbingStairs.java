/**
 * Problem: Climbing Stairs
 * Difficulty: Easy ⭐
 * 
 * Problem Statement:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Example:
 * Input: n = 3
 * Output: 3
 * Explanation: 1 step + 1 step + 1 step, 1 step + 2 steps, 2 steps + 1 step
 * 
 * Constraints:
 * - 1 <= n <= 45
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) for DP, O(1) for optimized
 */

public class ClimbingStairs {
    
    /**
     * APPROACH 1: Recursion with Memoization
     * Time: O(n), Space: O(n)
     */
    public static int climbStairsMemo(int n) {
        int[] memo = new int[n + 1];
        return climbHelper(n, memo);
    }
    
    private static int climbHelper(int n, int[] memo) {
        if (n == 0 || n == 1) return 1;
        if (memo[n] != 0) return memo[n];
        
        memo[n] = climbHelper(n - 1, memo) + climbHelper(n - 2, memo);
        return memo[n];
    }
    
    /**
     * APPROACH 2: Dynamic Programming (Tabulation)
     * Time: O(n), Space: O(n)
     */
    public static int climbStairsDP(int n) {
        if (n <= 1) return 1;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    /**
     * APPROACH 3: Space Optimized (Two Variables)
     * Time: O(n), Space: O(1)
     */
    public static int climbStairsOptimized(int n) {
        if (n <= 1) return 1;
        
        int prev = 1, curr = 1;
        
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        
        return curr;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Climbing Stairs ===");
        
        for (int n = 1; n <= 10; n++) {
            System.out.println("n = " + n + ": " + climbStairsOptimized(n) + " ways");
        }
    }
}
