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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode head = node;

        while (list1 != null || list2 != null) {
            ListNode next = null;
            node.next = new ListNode();
            if (list1 == null || list2 != null && list1.val >= list2.val) {
                next = list2.next;
                node.next = list2;
                list2 = next;
            } else if (list2 == null || list1 != null && list1.val < list2.val) {
                next = list1.next;
                node.next = list1;
                list1 = next;
            }
            
            node = node.next;
        }

        return head.next;
    }
}