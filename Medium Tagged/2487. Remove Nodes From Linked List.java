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
    ListNode root;
    public ListNode removeNodes(ListNode head) {
        traverse(head);
        return root;
    }
    
    private void traverse(ListNode head)
    {
        if(head.next==null){
            root=head;
            return;
        }
        traverse(head.next);
        if(root.val<=head.val)
        {
            head.next=root;
            root=head;
        }
    }
}
