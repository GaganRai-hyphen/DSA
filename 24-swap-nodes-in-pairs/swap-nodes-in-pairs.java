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
    public void rev(ListNode s , ListNode e){
      ListNode prev  = null , curr = s , next = e;
     while(prev != e){
           ListNode temp = curr.next;
           curr.next = prev;
           prev = curr;
           curr = temp;
        }

    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode s = head , e =  head.next;
        
        ListNode temp = swapPairs(e.next);
        rev(s , e);
        s.next = temp;
        return e;
        
    }
}