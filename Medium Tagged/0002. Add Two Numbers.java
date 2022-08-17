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
        int carry=0;
        ListNode root= l1;
        ListNode prev = null;
        while(l1!=null&&l2!=null){
            int sum=l1.val+l2.val+carry;
            l1.val=sum%10;
            carry = sum/10;
            prev=l1;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null)
        {
            int sum=l1.val+carry;
            l1.val=sum%10;
            carry = sum/10;
            prev=l1;
            l1=l1.next;
        }
        ListNode temp = l2;
        ListNode prev2=null;
        while(l2!=null)
        {
            int sum=l2.val+carry;
            l2.val=sum%10;
            carry = sum/10;
            prev2=l2;
            l2=l2.next;
        }
        if(temp!=null)
        {
            prev.next=temp;
            prev=prev2;
        }
        if(carry>0)
             prev.next = new ListNode(carry);
        return root;
    }

}
