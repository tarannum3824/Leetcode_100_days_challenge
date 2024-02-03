/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;



public class Solution {
    private Map<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }

        Node newNode = new Node(node.val);
        visited.put(newNode.val, newNode);

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }

        return newNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = List.of(node2, node4);
        node2.neighbors = List.of(node1, node3);
        node3.neighbors = List.of(node2, node4);
        node4.neighbors = List.of(node1, node3);

        Node clonedGraph1 = solution.cloneGraph(node1);
        System.out.println("Example 1 Output: " + clonedGraph1);

        // Example 2
        Node nodeEmpty = new Node(1);

        Node clonedGraph2 = solution.cloneGraph(nodeEmpty);
        System.out.println("Example 2 Output: " + clonedGraph2);

        // Example 3
        Node nodeNull = null;

        Node clonedGraph3 = solution.cloneGraph(nodeNull);
        System.out.println("Example 3 Output: " + clonedGraph3);
    }
}
