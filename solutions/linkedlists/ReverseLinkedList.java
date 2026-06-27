/**
 * Problem: Reverse Linked List
 * Difficulty: Easy ⭐
 * 
 * Problem Statement:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * Example:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * 
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 * 
 * Constraints:
 * - The number of nodes in the list is the range [0, 5000]
 * - -5000 <= Node.val <= 5000
 * 
 * Time Complexity: O(n) - where n is number of nodes
 * Space Complexity: 
 *   - Iterative: O(1) - only using pointers
 *   - Recursive: O(n) - due to recursion stack
 */

public class ReverseLinkedList {
    
    // Definition for singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
    }
    
    /**
     * APPROACH 1: Iterative Solution (Recommended)
     * Time: O(n), Space: O(1)
     * 
     * Idea:
     * - Use three pointers: prev, curr, next
     * - Traverse through the list
     * - At each node, reverse the link (curr.next = prev)
     * - Move prev and curr forward
     * 
     * Example:
     * 1 -> 2 -> 3 -> null
     * Step 1: null <- 1   2 -> 3 -> null (curr moves forward)
     * Step 2: null <- 1 <- 2   3 -> null
     * Step 3: null <- 1 <- 2 <- 3
     */
    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;      // Previous node
        ListNode curr = head;      // Current node
        
        while (curr != null) {
            // Store next node before changing links
            ListNode nextTemp = curr.next;
            
            // Reverse the link
            curr.next = prev;
            
            // Move prev and curr one step forward
            prev = curr;
            curr = nextTemp;
        }
        
        // prev is now pointing to the last node (new head)
        return prev;
    }
    
    /**
     * APPROACH 2: Recursive Solution
     * Time: O(n), Space: O(n) - recursion stack
     * 
     * Idea:
     * - Recursively reach the end of the list
     * - While unwinding, reverse the links
     * - Make the next node point back to current node
     * 
     * Example:
     * Recursion: 1 -> 2 -> 3 -> null
     *            Move to: 2 -> 3 -> null
     *            Move to: 3 -> null
     *            Base case: return null
     *            Unwind: 3.next.next = 3, 3.next = null
     *                    2.next.next = 2, 2.next = null
     *                    1.next.next = 1, 1.next = null
     */
    public static ListNode reverseListRecursive(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursively reverse the rest of the list
        // newHead will be the new head after reversal
        ListNode newHead = reverseListRecursive(head.next);
        
        // Make the next node point back to current
        // head.next is the node after head
        // (head.next).next = head makes it point back to head
        head.next.next = head;
        
        // Remove the forward link to avoid cycle
        head.next = null;
        
        return newHead;
    }
    
    /**
     * APPROACH 3: Stack-based Solution
     * Time: O(n), Space: O(n)
     * 
     * Idea:
     * - Push all nodes to a stack
     * - Pop from stack and build reversed list
     */
    public static ListNode reverseListStack(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        java.util.Stack<ListNode> stack = new java.util.Stack<>();
        ListNode curr = head;
        
        // Push all nodes to stack
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        
        // Pop from stack to build reversed list
        ListNode newHead = stack.pop();
        curr = newHead;
        
        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }
        
        // Set last node's next to null
        curr.next = null;
        
        return newHead;
    }
    
    /**
     * Helper function to create a linked list from array
     */
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }
    
    /**
     * Helper function to print linked list
     */
    public static void printList(ListNode head) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        System.out.println(result);
    }
    
    /**
     * Main function to test all approaches
     */
    public static void main(String[] args) {
        System.out.println("=== Reverse Linked List ===\n");
        
        // Test Case 1: [1,2,3,4,5]
        System.out.println("Test Case 1: [1,2,3,4,5]");
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Original: ");
        printList(head1);
        
        head1 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode reversed1 = reverseListIterative(head1);
        System.out.print("Reversed (Iterative): ");
        printList(reversed1);
        System.out.println();
        
        // Test Case 2: [1,2]
        System.out.println("Test Case 2: [1,2]");
        ListNode head2 = createList(new int[]{1, 2});
        System.out.print("Original: ");
        printList(head2);
        
        head2 = createList(new int[]{1, 2});
        ListNode reversed2 = reverseListRecursive(head2);
        System.out.print("Reversed (Recursive): ");
        printList(reversed2);
        System.out.println();
        
        // Test Case 3: [1]
        System.out.println("Test Case 3: [1]");
        ListNode head3 = createList(new int[]{1});
        System.out.print("Original: ");
        printList(head3);
        
        head3 = createList(new int[]{1});
        ListNode reversed3 = reverseListStack(head3);
        System.out.print("Reversed (Stack): ");
        printList(reversed3);
        System.out.println();
        
        // Test Case 4: []
        System.out.println("Test Case 4: []");
        ListNode head4 = createList(new int[]{});
        System.out.print("Original: ");
        printList(head4);
        
        ListNode reversed4 = reverseListIterative(head4);
        System.out.print("Reversed: ");
        printList(reversed4);
    }
}

/**
 * KEY TAKEAWAYS:
 * 
 * 1. ITERATIVE APPROACH (Best for interviews):
 *    - Most efficient (O(1) space)
 *    - Easiest to understand and implement
 *    - Three pointers: prev, curr, next
 *    - Remember: reverse link, then move pointers forward
 * 
 * 2. RECURSIVE APPROACH:
 *    - Elegant but uses O(n) stack space
 *    - Key: make next node point back to current
 *    - Must set current's next to null to avoid cycle
 * 
 * 3. COMMON MISTAKES:
 *    - Not saving next node before reversing
 *    - Creating infinite loops (not setting next to null)
 *    - Off-by-one errors with pointers
 * 
 * 4. INTERVIEW TIPS:
 *    - Draw the diagram while explaining
 *    - Start with iterative approach
 *    - Explain edge cases (empty, single node)
 *    - Mention space/time complexity
 * 
 * 5. VARIATIONS:
 *    - Reverse between positions L and R
 *    - Reverse in groups of K
 *    - Reverse every alternative nodes
 */
