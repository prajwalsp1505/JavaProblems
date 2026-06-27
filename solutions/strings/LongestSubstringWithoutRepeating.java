/**
 * Problem: Longest Substring Without Repeating Characters
 * Difficulty: Medium 🔶
 * 
 * Problem Statement:
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Constraints:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols and spaces
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(min(m, n)) where m is charset size
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    
    /**
     * APPROACH 1: Sliding Window with HashMap (Recommended)
     * Time: O(n), Space: O(min(m, n))
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // If character is already in window, move left pointer
            if (charIndex.containsKey(c)) {
                left = Math.max(left, charIndex.get(c) + 1);
            }
            
            // Update character's latest position
            charIndex.put(c, right);
            
            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    /**
     * APPROACH 2: Sliding Window with Array
     * Time: O(n), Space: O(1)
     */
    public static int lengthOfLongestSubstringArray(String s) {
        int[] charIndex = new int[256];
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(left, charIndex[c]);
            charIndex[c] = right + 1;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Longest Substring Without Repeating Characters ===");
        
        String s1 = "abcabcbb";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s1));
        System.out.println();
        
        String s2 = "bbbbb";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s2));
        System.out.println();
        
        String s3 = "pwwkew";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s3));
        System.out.println();
        
        String s4 = "au";
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s4));
    }
}
