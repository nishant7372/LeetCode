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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int a = head.val;
         head=head.next;
        int b = head.val;
         head=head.next;
        int i=1;
        if(head==null)
        return new int[]{-1,-1};
        int[] res = new int[2];
        while(head!=null)
        {
            int c = head.val;
            if(b<c && b<a)
            list.add(i);
            else if(b>c && b>a)
            list.add(i);
            a=b;
            b=c;
            i++;
            head=head.next;
        }
        int min = Integer.MAX_VALUE;
        for(i=0;i<list.size()-1;i++)
        {
            if(list.get(i+1)-list.get(i)<min)
            {
                min=list.get(i+1)-list.get(i);
            }
        }
        if(list.size()<2)
        return new int[]{-1,-1};
        return new int[]{min,list.get(list.size()-1)-list.get(0)};
    }
}
