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
    ListNode root = new ListNode();
    public ListNode reverseList(ListNode head) {
        ListNode h = root;
        dfs(head, null);
        return h.next;
    }

    void dfs(ListNode head, ListNode pre) {
        if(head == null) {
            root.next = pre;
            root = root.next;
            return;
        }
        dfs(head.next, head);
        
        root.next = pre;
        root = root.next;
    }
}