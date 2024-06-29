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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode head = node;


        while (l1 != null || l2 != null) {
            if (l1 == null && l2 != null) {
                node.val += l2.val;
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                node.val += l1.val;
                l1 = l1.next;
            } else if (l1 != null && l2 != null) {
                node.val += (l1.val + l2.val);
                l1 = l1.next;
                l2 = l2.next;
            }

            int val = node.val;

            if (l1 == null && l2 == null) {
                if (val >= 10) {
                    node.val = val % 10;
                    node.next = new ListNode();
                    node.next.val += (val / 10);
                }
                break;
            }

            node.next = new ListNode();
            node.next.val += (val / 10);
            node.val = val % 10;
            node = node.next;
        }

        return head;
    }
}