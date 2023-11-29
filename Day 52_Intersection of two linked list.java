/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         int lenA = getLength(headA);
        int lenB = getLength(headB);

        // Move the longer linked list's pointer by the absolute difference in lengths
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // Move both pointers until they meet
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        // Either headA or headB is the intersection point (or null if there is no intersection)
        return headA;
    }

    // Helper function to get the length of a linked list
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}