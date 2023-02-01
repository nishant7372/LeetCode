// Method 1 --> Iterative using Stack 

class Solution {
    public boolean isPalindrome(ListNode head) 
    {
        Stack<Integer> st = new Stack<>();
        ListNode root = head, fast = head;
        while(fast!=null && fast.next!=null){
            st.push(head.val);
            head=head.next;
            fast=fast.next.next;
        }
        if(fast!=null && fast.next==null)
           head=head.next;
        while(head!=null){
            if(st.pop()!=head.val)
               return false;
            head=head.next;
        }
        return true;
    }    
}


// Method 2 --> Recursive 

class Solution {
    ListNode root;
    public boolean isPalindrome(ListNode head) 
    {
        ListNode fast = head;
        this.root = head;
        while(fast!=null && fast.next!=null)
        {
            head = head.next;
            fast = fast.next.next;
        }
        return check(head);
    }    
    
    private boolean check(ListNode head)
    {
        if(head==null)
        return true;
        boolean res = check(head.next);
        if(head.val!=root.val){
            root = root.next;
            return false;
        }
        else{
            root = root.next;
            return res; 
        }
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
