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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            
            // If there is a right child, push it onto the stack
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            
            // If there is a left child, push it onto the stack
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }

            // Flatten the tree by setting the right child to the next node in the stack
            if (!stack.isEmpty()) {
                currentNode.right = stack.peek();
            }

            // Set the left child to null
            currentNode.left = null;
        }
    }
}
