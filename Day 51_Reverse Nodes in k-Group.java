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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // Check if there are k nodes remaining
            ListNode current = prevGroupEnd.next;
            ListNode groupEnd = prevGroupEnd;
            int count = 0;

            while (count < k && groupEnd != null) {
                groupEnd = groupEnd.next;
                count++;
            }

            if (groupEnd == null) {
                // Less than k nodes remaining, break
                break;
            }

            // Reverse the k nodes
            ListNode nextGroupStart = groupEnd.next;
            groupEnd.next = null; // Break the group
            reverseList(current);
            prevGroupEnd.next = groupEnd; // Connect the reversed group
            current.next = nextGroupStart; // Connect the reversed group to the next part

            // Move to the next group
            prevGroupEnd = current;
        }

        return dummy.next;
    }

    private void reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }
}