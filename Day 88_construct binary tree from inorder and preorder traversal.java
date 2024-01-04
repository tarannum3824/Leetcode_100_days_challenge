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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Creating a hashmap for storing the values of inorder traversal
        Map <Integer,Integer> HashMapInOrder =new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            //value stored in hashmap in value pair form
            HashMapInOrder.put(inorder[i],i);
        }
        return SplitTree(preorder,HashMapInOrder,0,0,inorder.length-1);
    }
    private TreeNode SplitTree(int [] preorder, Map<Integer,Integer> HashMapInOrder, int rootindex,int left, int right){
        //taking root from preorder
        TreeNode root=new TreeNode(preorder[rootindex]);
        //Getting mid value from hashmapinoredr
        int  middlevalue = HashMapInOrder.get(preorder[rootindex]);
        //making left sub tree
        if(middlevalue > left){
            root.left=SplitTree(preorder,HashMapInOrder,rootindex+1,left,middlevalue-1);
        }
        //making right sub tree
        if(middlevalue < right){
            root.right=SplitTree(preorder,HashMapInOrder,rootindex+middlevalue-left+1,middlevalue+1,right);
        }
        return root;
    }
}