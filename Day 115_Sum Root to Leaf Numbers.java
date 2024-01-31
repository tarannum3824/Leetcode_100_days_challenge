/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }
    
    private int sumNumbersHelper(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }
        
        // Calculate the sum of the current root-to-leaf path
        currentSum = currentSum * 10 + node.val;
        
        // If the current node is a leaf, return the sum
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        
        // Recursively calculate the sum for left and right subtrees
        int leftSum = sumNumbersHelper(node.left, currentSum);
        int rightSum = sumNumbersHelper(node.right, currentSum);
        
        // Return the total sum for the current subtree
        return leftSum + rightSum;
    }
}
