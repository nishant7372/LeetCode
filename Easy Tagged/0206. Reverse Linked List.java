//Proper Recursive Approach - 0ms runtime faster than 100%

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
    ListNode main = null;
    ListNode root = main;
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        reverse(head);
        root.next=null;
        return main;
    }
    
    private void reverse(ListNode head)
    {
        if(head.next==null)
        {
            main = head;
            root=head;
            return;
        }
        reverse(head.next);
        root.next = head;
        root= root.next;
    }
}
