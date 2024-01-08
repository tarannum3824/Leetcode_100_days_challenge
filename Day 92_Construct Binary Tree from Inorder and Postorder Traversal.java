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

import java.util.HashMap;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // Using an array for post_index to maintain its state across recursive calls
        int[] post_index = new int[]{postorder.length - 1};
        return buildTree1(postorder, 0, inorder.length - 1, post_index, map);
    }

    private TreeNode buildTree1(int[] postorder, int inorderStart, int inorderEnd, int[] post_index, HashMap<Integer, Integer> map) {
        if (inorderStart > inorderEnd) return null;

        TreeNode root = new TreeNode(postorder[post_index[0]]);
        int index = map.get(root.val);

        // Decrement post_index for the left subtree after building the right subtree
        post_index[0]--;
        root.right = buildTree1(postorder, index + 1, inorderEnd, post_index, map);
        root.left = buildTree1(postorder, inorderStart, index - 1, post_index, map);

        return root;
    }
}
