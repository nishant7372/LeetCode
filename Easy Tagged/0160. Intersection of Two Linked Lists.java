public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1!=null)
        {
            while(temp2!=null)
            {
                if(temp1==temp2)
                    return temp1;
                temp2=temp2.next;
            }
            temp2=headB;
            temp1=temp1.next;
        }
        return null;
    }
}
