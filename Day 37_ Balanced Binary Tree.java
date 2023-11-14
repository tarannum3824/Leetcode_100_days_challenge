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
    public boolean isBalanced(TreeNode root) {
         return checkBalanced(root) != -1;
    }

    private int checkBalanced(TreeNode node) {
        if (node == null) {
            return 0; // Height of an empty tree is 0.
        }

        int leftHeight = checkBalanced(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is not balanced.
        }

        int rightHeight = checkBalanced(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is not balanced.
        }

        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) {
            return -1; // Tree is not balanced.
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}