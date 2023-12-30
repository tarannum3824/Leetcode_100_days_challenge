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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        // Step 1: Find the length of the linked list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Calculate the effective rotation value
        int effectiveK = k % length;
        if (effectiveK == 0) {
            return head; // No rotation needed
        }

        // Step 3: Find the new tail node after rotation
        ListNode newTail = head;
        for (int i = 0; i < length - effectiveK - 1; i++) {
            newTail = newTail.next;
        }

        // Step 4: Update pointers for rotation
        ListNode newHead = newTail.next;
        newTail.next = null; // Set the new tail's next to null
        tail.next = head; // Connect the original tail to the original head

        return newHead;
    }
}
