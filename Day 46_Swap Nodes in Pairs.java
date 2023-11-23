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
class Solution {
    public ListNode swapPairs(ListNode head) {
         // Create a dummy node to simplify code
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize pointers for swapping
        ListNode prev = dummy;
        
        while (head != null && head.next != null) {
            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            
            // Swapping
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            
            // Move to the next pair
            prev = firstNode;
            head = firstNode.next;
        }
        
        return dummy.next;
    }
}