// Approach 1 -> 2ms runtime Beats 96%

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        //A sentinel node is a dummy node that goes at the front of a list
        ListNode root = new ListNode(0); //sentinel node
        ListNode head = root;
        while(l1!=null || l2!=null){
            int sum=0;
            if(l1!=null && l2!=null)
               sum=l1.val+l2.val+carry;
            else if(l1!=null)
               sum=l1.val+carry;
            else if(l2!=null)
               sum=l2.val+carry;
            
            head.next = new ListNode(sum%10);
            head=head.next;
            carry = sum/10;
            if(l1!=null)
               l1=l1.next;
            if(l2!=null)
               l2=l2.next;
        }
        if(carry>0)
           head.next = new ListNode(carry);
        return root.next;
    }

}


// Approach 2 --> 3ms runtime Beats 45%

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
