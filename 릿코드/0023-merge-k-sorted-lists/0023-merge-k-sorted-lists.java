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
    List<Integer> sortedList = new ArrayList<Integer>();
    ListNode head = new ListNode();
    ListNode result = head;

    public ListNode mergeKLists(ListNode[] lists) {
        for(ListNode node : lists) {
            while(node != null) {
                sortedList.add(node.val);
                node = node.next;
            }
        }

        if(sortedList.size() == 0) return null;

        Collections.sort(sortedList);
        for(int i=0; i<sortedList.size(); i++) {
            head.val = sortedList.get(i);
            if(i != sortedList.size()-1) {
                head.next = new ListNode();
                head = head.next;
            }
        }
        return result;
    }
}