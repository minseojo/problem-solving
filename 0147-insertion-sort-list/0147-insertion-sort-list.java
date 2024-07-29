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
    public ListNode insertionSortList(ListNode head) {
        ListNode root = new ListNode();
        ListNode node = root;

        while (head != null) {
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }

            ListNode nodeNext = node.next;
            ListNode headNext = head.next;
            node.next = head;
            head.next = nodeNext; 
            head = headNext;
            node = root;
        }

        return root.next;
    }
}