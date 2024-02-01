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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0); // Create a dummy node to handle the case when the head itself is a duplicate
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            boolean isDuplicate = false;

            // Check if the current node has duplicates
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
                isDuplicate = true;
            }

            // If there are duplicates, skip the duplicates
            if (isDuplicate) {
                prev.next = current.next;
            } else {
                prev = prev.next;
            }

            // Move to the next node
            current = current.next;
        }

        return dummy.next;
    }
}
