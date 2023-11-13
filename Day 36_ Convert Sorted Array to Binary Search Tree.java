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
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }

            return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
        }

        private TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }

            // Find the middle element of the array
            int mid = start + (end - start) / 2;

            // Create a new node with the middle element as the root
            TreeNode root = new TreeNode(nums[mid]);

            // Recursively build the left and right subtrees
            root.left = sortedArrayToBSTHelper(nums, start, mid - 1);
            root.right = sortedArrayToBSTHelper(nums, mid + 1, end);

            return root;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();

            int[] nums1 = {-10, -3, 0, 5, 9};
            TreeNode result1 = solution.sortedArrayToBST(nums1);
            System.out.println(result1);

            int[] nums2 = {1, 3};
            TreeNode result2 = solution.sortedArrayToBST(nums2);
            System.out.println(result2);
        }
    }