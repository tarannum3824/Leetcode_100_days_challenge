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
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true; //An empty tree is always symmetric
        }
        else {
            return isSame(root.left, root.right);
        }
    }
        public boolean isSame(TreeNode t1, TreeNode t2){
            if(t1==null && t2==null){
                return true; //both subtree are empty so tree is symmetric
            }
            if(t1==null || t2==null){
                return false; //one tree is empty so tree is not symmetric
            }
            else{
               return  t1.val==t2.val && isSame(t1.left, t2.right) && isSame(t1.right, t2.left);
            }
        }

    }