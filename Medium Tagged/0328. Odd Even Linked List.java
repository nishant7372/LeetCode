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
    public ListNode oddEvenList(ListNode head) {
        ListNode root1 = new ListNode(0);
        ListNode root2 = new ListNode(0);
        ListNode temp1 = root1;
        ListNode temp2 = root2;
        int c=0;
        while(head!=null)
        {
            if(c%2==0){
                temp1.next = head;
                head=head.next;
                temp1 = temp1.next;
                temp1.next = null;
            }
            else{
                temp2.next = head;
                head=head.next;
                temp2 = temp2.next;
                temp2.next = null;
            }
            c++;
        }
        temp1.next = root2.next;
        return root1.next;
    }
}
