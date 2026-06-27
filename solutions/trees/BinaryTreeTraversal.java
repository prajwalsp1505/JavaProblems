/**
 * Problem: Binary Tree Traversal
 * Difficulty: Easy ⭐
 * 
 * Traversals: Inorder, Preorder, Postorder, Level Order
 * 
 * Problem Statement:
 * Given the root of a binary tree, return all possible traversals.
 * 
 * Time Complexity: O(n) for all traversals
 * Space Complexity: O(h) for recursive, O(n) for iterative
 */

import java.util.*;

public class BinaryTreeTraversal {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
    
    // ===== INORDER TRAVERSAL (Left -> Root -> Right) =====
    
    /**
     * Inorder Recursive
     */
    public static void inorderRecursive(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderRecursive(root.left, result);
        result.add(root.val);
        inorderRecursive(root.right, result);
    }
    
    /**
     * Inorder Iterative using Stack
     */
    public static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            // Go to left most node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // Current is null, pop from stack
            curr = stack.pop();
            result.add(curr.val);
            
            // Visit right subtree
            curr = curr.right;
        }
        
        return result;
    }
    
    // ===== PREORDER TRAVERSAL (Root -> Left -> Right) =====
    
    /**
     * Preorder Recursive
     */
    public static void preorderRecursive(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preorderRecursive(root.left, result);
        preorderRecursive(root.right, result);
    }
    
    /**
     * Preorder Iterative
     */
    public static List<Integer> preorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            
            // Push right first, then left (so left is processed first)
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        
        return result;
    }
    
    // ===== POSTORDER TRAVERSAL (Left -> Right -> Root) =====
    
    /**
     * Postorder Recursive
     */
    public static void postorderRecursive(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postorderRecursive(root.left, result);
        postorderRecursive(root.right, result);
        result.add(root.val);
    }
    
    /**
     * Postorder Iterative
     */
    public static List<Integer> postorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;
        
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode top = stack.peek();
                
                // If right child exists and not visited, visit right
                if (top.right != null && top.right != lastVisited) {
                    curr = top.right;
                } else {
                    result.add(top.val);
                    lastVisited = stack.pop();
                }
            }
        }
        
        return result;
    }
    
    // ===== LEVEL ORDER TRAVERSAL (BFS) =====
    
    /**
     * Level Order using Queue
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            
            result.add(level);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Binary Tree Traversal ===");
        
        // Create sample tree
        //       1
        //      / \\
        //     2   3
        //    / \\
        //   4   5
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        System.out.println("Inorder (Left-Root-Right): ");
        List<Integer> inorder = new ArrayList<>();
        inorderRecursive(root, inorder);
        System.out.println(inorder);
        
        System.out.println("\nPreorder (Root-Left-Right): ");
        List<Integer> preorder = new ArrayList<>();
        preorderRecursive(root, preorder);
        System.out.println(preorder);
        
        System.out.println("\nPostorder (Left-Right-Root): ");
        List<Integer> postorder = new ArrayList<>();
        postorderRecursive(root, postorder);
        System.out.println(postorder);
        
        System.out.println("\nLevel Order (BFS): ");
        System.out.println(levelOrder(root));
    }
}
