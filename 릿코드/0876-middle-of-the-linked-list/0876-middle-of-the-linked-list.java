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
    public ListNode middleNode(ListNode head) {
        ListNode n = head;
        int end = 1;
        while(n.next != null) {
            end++;
            n = n.next;
        }
        System.out.println(end);
        
        n = head;
        int cur = 1;
        while(n != null) {
            if(cur == (end/2)+1) {
                head = n;
                break;
            }
            cur++;
            n = n.next;
        }
        
        return head;
    }
}