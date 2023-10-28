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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode mandi=head;  //slow pointer
        ListNode tivra=head; //speed pointer
        while(n-->0){
            tivra=tivra.next;
        }
        while(tivra!=null && tivra.next!=null){  //for first condition
            tivra=tivra.next;
            mandi=mandi.next;
        }
        //for second condition where list is empty
        if(mandi==null || mandi.next==null){
            return null;
        }
        //third condition
        else if(mandi==head && tivra==null){
            head=head.next;
        }
        else{
            mandi.next=mandi.next.next;
        }
        return head;
    }
}