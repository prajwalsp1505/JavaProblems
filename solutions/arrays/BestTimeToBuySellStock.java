/**
 * Problem: Best Time to Buy and Sell Stock
 * Difficulty: Easy ⭐
 * 
 * Problem Statement:
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and a different day
 * in the future to sell that stock. Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 * 
 * Example:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * 
 * Constraints:
 * - 1 <= prices.length <= 10^5
 * - 0 <= prices[i] <= 10^4
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

public class BestTimeToBuySellStock {
    
    /**
     * APPROACH 1: Single Pass Greedy (Recommended)
     * Time: O(n), Space: O(1)
     * 
     * Idea:
     * - Track minimum price seen so far
     * - For each price, calculate profit if we sell at that price
     * - Keep track of maximum profit
     */
    public static int maxProfitGreedy(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            // Update minimum price
            minPrice = Math.min(minPrice, price);
            
            // Calculate profit if we sell at current price
            int profit = price - minPrice;
            
            // Update maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }
        
        return maxProfit;
    }
    
    /**
     * APPROACH 2: Brute Force (Not recommended)
     * Time: O(n^2), Space: O(1)
     */
    public static int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        
        return maxProfit;
    }
    
    /**
     * APPROACH 3: Dynamic Programming
     * Time: O(n), Space: O(1)
     */
    public static int maxProfitDP(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int maxProfit = 0;
        int minBuyPrice = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            // Profit if we sell at current day
            maxProfit = Math.max(maxProfit, prices[i] - minBuyPrice);
            
            // Update min buy price
            minBuyPrice = Math.min(minBuyPrice, prices[i]);
        }
        
        return maxProfit;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Best Time to Buy and Sell Stock ===");
        
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Input: " + Arrays.toString(prices1));
        System.out.println("Output: " + maxProfitGreedy(prices1));
        System.out.println("Explanation: Buy on day 2 (price=1), sell on day 5 (price=6), profit=5");
        System.out.println();
        
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Input: " + Arrays.toString(prices2));
        System.out.println("Output: " + maxProfitGreedy(prices2));
        System.out.println("Explanation: No profit possible, prices only decrease");
        System.out.println();
        
        int[] prices3 = {2, 4, 1, 7, 5, 11};
        System.out.println("Input: " + Arrays.toString(prices3));
        System.out.println("Output: " + maxProfitGreedy(prices3));
        System.out.println("Explanation: Buy at 1, sell at 11, profit=10");
    }
}
