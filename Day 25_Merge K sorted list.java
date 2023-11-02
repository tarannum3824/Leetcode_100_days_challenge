/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Create a priority queue with a custom comparator to compare ListNode values
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return Integer.compare(l1.val, l2.val);
            }
        });
        
        // Add the first node of each linked list to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        
        // Create a dummy node to simplify the code
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // While the priority queue is not empty, keep adding the smallest element
        // to the result list and update the current pointer
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;
            
            // If the smallest element has a next node, add it to the priority queue
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }
        
        return dummy.next;
    }
}
