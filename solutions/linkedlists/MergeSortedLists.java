/**
 * Problem: Merge Two Sorted Lists
 * Difficulty: Easy ⭐
 * 
 * Problem Statement:
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together
 * the nodes of the two lists. Return the head of the merged linked list.
 * 
 * Example:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * 
 * Constraints:
 * - The number of nodes in both lists is in the range [0, 50]
 * - -100 <= Node.val <= 100
 * 
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */

public class MergeSortedLists {
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    /**
     * APPROACH 1: Iterative (Recommended)
     * Time: O(n + m), Space: O(1)
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify logic
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        // Traverse both lists and add smaller node to result
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        // Attach remaining nodes
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }
        
        return dummy.next;
    }
    
    /**
     * APPROACH 2: Recursive
     * Time: O(n + m), Space: O(n + m) - recursion stack
     */
    public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        // Base cases
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        // Recursively merge
        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }
    
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
    
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Merge Two Sorted Lists ===");
        
        ListNode list1 = createList(new int[]{1, 2, 4});
        ListNode list2 = createList(new int[]{1, 3, 4});
        
        System.out.print("List 1: ");
        printList(list1);
        System.out.print("List 2: ");
        printList(list2);
        
        ListNode merged = mergeTwoLists(list1, list2);
        System.out.print("Merged: ");
        printList(merged);
    }
}
