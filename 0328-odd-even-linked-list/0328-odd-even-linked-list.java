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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 홀 수 리스트
        ListNode node = head;
        ListNode oddNode = new ListNode();
        ListNode evenNode = new ListNode();
        ListNode oddNodeTail = null;
        ListNode result = oddNode;

        while (node != null) {
            oddNode.next = node;
            evenNode.next = node.next;
            oddNode = oddNode.next;
            evenNode = node.next;
            if (oddNodeTail == null) oddNodeTail = evenNode;
            
            if (node.next != null && node.next.next != null) node = node.next.next;
            else break;
        }

        oddNode.next = oddNodeTail;
        return result.next;
    }
}