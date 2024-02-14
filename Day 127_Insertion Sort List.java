class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode(-1); // Dummy node to mark the head of sorted list
        ListNode curr = head; // Current node to be inserted into the sorted list
        
        while (curr != null) {
            ListNode prevSorted = dummy; // Pointer to the last node in the sorted list
            ListNode nextCurr = curr.next; // Pointer to the next node in the given list
            
            // Find the correct position to insert the current node in the sorted list
            while (prevSorted.next != null && prevSorted.next.val < curr.val) {
                prevSorted = prevSorted.next;
            }
            
            // Insert the current node into the sorted list
            curr.next = prevSorted.next;
            prevSorted.next = curr;
            
            // Move to the next node in the given list
            curr = nextCurr;
        }
        
        return dummy.next; // Return the head of the sorted list
    }
}
