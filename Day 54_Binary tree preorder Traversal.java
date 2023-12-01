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
    public List<Integer> preorderTraversal(TreeNode root) {
        List <Integer> preorderparinam=new ArrayList<Integer>(); 
        if(root == null) return preorderparinam;
        Stack <TreeNode> dandi= new Stack<TreeNode>();
        dandi.push(root);
        while(!dandi.isEmpty()){
            root=dandi.pop();
            preorderparinam.add(root.val);
            if(root.right!=null){
                dandi.push(root.right);
            }
            if(root.left!=null){
                dandi.push(root.left);
            }
        }
        return preorderparinam;

    }
}