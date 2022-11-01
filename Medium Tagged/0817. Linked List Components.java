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
    public int numComponents(ListNode head, int[] nums) {
        int max=0;
        for(int x:nums)
        {
            if(x>max)
                max=x;
        }
        int[] a= new int[max+1];
        
        for(int x:nums)
            a[x]++;
        
        int c=0;
        int components=0;
        while(head!=null)
        {
            if(head.val<=max&&a[head.val]==1){
                c++;
            }
            else{
                if(c>0){
                    components++;
                    c=0;
                }
            }
            head=head.next;
        }
        if(c>0)
            components++;
        return components;
    }
}
