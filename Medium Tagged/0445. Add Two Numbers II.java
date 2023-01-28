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
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        
        ListNode root = null;

        while(l1!=null || l2!=null){
            if(l1!=null){
               st1.push(l1.val);
               l1=l1.next;
            }
            if(l2!=null){
               st2.push(l2.val);
               l2=l2.next;
            }
        }
        int carry=0;
        while(!st1.isEmpty() || !st2.isEmpty()){
            int sum=0;
            if(!st1.isEmpty() && !st2.isEmpty()){
                sum=st1.pop()+st2.pop()+carry;
            }
            else if(!st1.isEmpty()){
                sum=st1.pop()+carry;
            }
            else if(!st2.isEmpty()){
                sum=st2.pop()+carry;
            }
            ListNode newNode = new ListNode(sum%10);
            if(root!=null)
               newNode.next=root;
            root=newNode;
            carry = sum/10;

        }
        if(carry>0){
            ListNode newNode = new ListNode(carry);
            newNode.next=root;
            root=newNode;
        }
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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        
        ListNode root = null;

        while(l1!=null || l2!=null){
            if(l1!=null){
               st1.push(l1.val);
               l1=l1.next;
            }
            if(l2!=null){
               st2.push(l2.val);
               l2=l2.next;
            }
        }
        int carry=0;
        while(!st1.isEmpty() || !st2.isEmpty()){
            int sum=(st1.isEmpty()? 0:st1.pop()) + (st2.isEmpty()? 0:st2.pop())+carry;
            ListNode newNode = new ListNode(sum%10);
            if(root!=null)
               newNode.next=root;
            root=newNode;
            carry = sum/10;

        }
        if(carry>0){
            ListNode newNode = new ListNode(carry);
            newNode.next=root;
            root=newNode;
        }
        return root;
    }
}
