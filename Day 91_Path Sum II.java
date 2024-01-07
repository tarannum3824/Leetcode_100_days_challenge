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
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        pathSumHelper(root, targetSum, currentPath, result);
        return result;
    }

    private void pathSumHelper(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // Add the current node value to the path
        currentPath.add(node.val);

        // Check if the current node is a leaf and if the path sum equals the targetSum
        if (node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(currentPath));
        }

        // Recursively check left and right subtrees
        pathSumHelper(node.left, targetSum - node.val, currentPath, result);
        pathSumHelper(node.right, targetSum - node.val, currentPath, result);

        // Remove the current node from the path to backtrack
        currentPath.remove(currentPath.size() - 1);
    }
}
