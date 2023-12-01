import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderparinam = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null; // To keep track of the previously visited node

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode top = stack.peek();
                if (top.right != null && top.right != prev) {
                    // If the right child exists and has not been processed yet
                    root = top.right;
                } else {
                    // If the right child is null or has been processed
                    postorderparinam.add(top.val);
                    prev = stack.pop();
                }
            }
        }

        return postorderparinam;
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        Solution solution = new Solution();
        List<Integer> result = solution.postorderTraversal(root);
        System.out.println(result); // Output: [3, 2, 1]
    }
}
