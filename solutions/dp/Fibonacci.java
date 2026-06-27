/**
 * Problem: Fibonacci Number
 * Difficulty: Easy ⭐
 * 
 * Problem Statement:
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1.
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * 
 * Given n, calculate F(n).
 * 
 * Example:
 * Input: n = 2
 * Output: 1
 * 
 * Constraints:
 * - 0 <= n <= 30
 */

public class Fibonacci {
    
    /**
     * APPROACH 1: Recursion (Not recommended - exponential time)
     * Time: O(2^n), Space: O(n) - recursion depth
     */
    public static int fibRecursive(int n) {
        if (n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }
    
    /**
     * APPROACH 2: Memoization (Top-Down DP)
     * Time: O(n), Space: O(n)
     */
    public static int fibMemoization(int n) {
        int[] memo = new int[n + 1];
        return fibMemoHelper(n, memo);
    }
    
    private static int fibMemoHelper(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        
        memo[n] = fibMemoHelper(n - 1, memo) + fibMemoHelper(n - 2, memo);
        return memo[n];
    }
    
    /**
     * APPROACH 3: Tabulation (Bottom-Up DP)
     * Time: O(n), Space: O(n)
     */
    public static int fibTabulation(int n) {
        if (n <= 1) return n;
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    /**
     * APPROACH 4: Space Optimized
     * Time: O(n), Space: O(1)
     */
    public static int fibOptimized(int n) {
        if (n <= 1) return n;
        
        int prev = 0, curr = 1;
        
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        
        return curr;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Fibonacci Number ===");
        
        for (int n = 0; n <= 10; n++) {
            System.out.println("F(" + n + ") = " + fibOptimized(n));
        }
    }
}
