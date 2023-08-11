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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = root;
        dfs(list1, list2);
        return head.next;
    }

    void dfs(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return;
        
        else if(list1 == null) {
            root.next = list2;
            list2 = list2.next;
        } 
        
        else if(list2 == null) {
            root.next = list1;
            list1 = list1.next;
        } 
        
        else {
            if(list1.val < list2.val) {
                root.next = list1;
                list1 = list1.next;
            } else {
                root.next = list2;
                list2 = list2.next;
            }
        }
        root = root.next;
        dfs(list1, list2);
    }
}