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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((i, j) -> Integer.compare(i.val, j.val));
        for (ListNode node : lists) {
            while (node != null) {
                pq.add(node);
                node = node.next;
            }
        }

        ListNode node = new ListNode();
        ListNode head = node;
        while (!pq.isEmpty()) {
            node.next = pq.poll();
            node = node.next;
        }
        node.next = null;
        return head.next;
    }
}