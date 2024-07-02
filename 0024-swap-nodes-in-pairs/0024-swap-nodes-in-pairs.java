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
        if (head == null || head.next == null) return head;

        ListNode node = new ListNode();
        node.next = head;
        ListNode root = node;
        
        while (node.next != null && node.next.next != null) {
            ListNode a = node.next;
            ListNode b = node.next.next;
            a.next = b.next;
            b.next = a;
            node.next = b;
            node = a;
        }

        return root.next;
    }
}