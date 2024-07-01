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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;

        ListNode node = new ListNode();
        node.next = head; 

        ListNode prev = null;
        ListNode cur = node;

        for (int i = 0; i < left; i++) {
            prev = cur;
            cur = cur.next;
        }

        ListNode revPrev = prev;
        ListNode revCur = cur;
        for (int i = left; i <= right; i++) {
            ListNode next = revCur.next;
            revCur.next = revPrev;
            revPrev = revCur;
            revCur = next;
        }

        prev.next = revPrev;
        cur.next = revCur;
        return node.next;

    }
}