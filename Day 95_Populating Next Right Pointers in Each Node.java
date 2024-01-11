
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        connectNodes(root.left, root.right);
        return root;
    }
    
    private void connectNodes(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        
        // Connect nodes in the same parent
        node1.next = node2;
        
        // Recursively connect nodes in the left and right subtrees
        connectNodes(node1.left, node1.right);
        connectNodes(node1.right, node2.left);
        connectNodes(node2.left, node2.right);
    }
}
