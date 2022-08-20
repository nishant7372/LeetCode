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
    public void reorderList(ListNode head) {
        ArrayList<ListNode> a = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null)
        {
            a.add(temp);
            temp=temp.next;
        }
        int i=0;
        int j=a.size()-1;
        ArrayList<ListNode> b = new ArrayList<>();
        while(i<=j)
        {
            b.add(a.get(i++));
            b.add(a.get(j--));
        }
        for(i = 1;i<b.size();i++)
        {
            b.get(i-1).next=b.get(i);
        }
        b.get(b.size()-1).next=null;
    }
}
