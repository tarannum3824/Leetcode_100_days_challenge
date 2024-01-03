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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList();
        List<List<Integer>> Parinam=new ArrayList();
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        boolean ReverseLevel= false;
        while(!q.isEmpty()){
            List<Integer> Level=new ArrayList();
            int size= q.size();
            while(size-- >0){
                root=q.poll();
                Level.add(root.val);
                if(root.left !=null) q.add(root.left);
                if(root.right !=null) q.add(root.right); 
            }
            if(ReverseLevel) Collections.reverse(Level);
            Parinam.add(Level);
            ReverseLevel =!ReverseLevel;
        }
        return Parinam;

    }
}