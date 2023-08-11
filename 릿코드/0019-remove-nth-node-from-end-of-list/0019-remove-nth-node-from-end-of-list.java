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
    public ListNode result = null;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode();
        node.next= head;
        result = node;

        travel(node, n, 1);
        return result.next;
    }
    
    int travel(ListNode head, int n, int nthFromEnd) {
        if(head.next != null) nthFromEnd = travel(head.next, n, nthFromEnd);
        //System.out.println(nthFromEnd + " " + head.val);
        if(nthFromEnd == n+1) head.next = head.next.next;

        return nthFromEnd+1;
    }
}