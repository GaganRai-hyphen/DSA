/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    public Pair<Node, Node> splitList(Node head) {
        // Code here
        Node slow = head , fast = head.next ;
        
        while(fast != head && fast.next != head){
            slow = slow.next;
            fast = fast.next;
            
            if(fast.next != head)fast = fast.next;
        }
        
        fast.next = slow.next;
        slow.next = head;
        
        return new Pair<Node , Node>(head , fast.next);
    }
} 