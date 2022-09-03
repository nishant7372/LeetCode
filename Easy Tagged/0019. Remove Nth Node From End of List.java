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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        n=length(head,0)-n;
        if(n==0)
            return head.next;
        ListNode temp=head;
        while(n!=1)
        {
            temp=temp.next;
            n--;
        }
        temp.next = temp.next.next;
        return head;
    }
    
    private int length(ListNode head,int c)
    {
        if(head==null)
            return c;
        return length(head.next,c+1);
    }
}
