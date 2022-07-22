class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode a=null;
        ListNode b=null;
        ListNode first = null;
        ListNode second=null;
        while(head!=null)
        {
            if(head.val<x)
            {
                if(first==null)
                {
                    a=head;
                    first=a;
                }
                else
                {
                    a.next=head;
                    a=a.next;
                }
            }
            else
            {
                if(second==null)
                {
                    b=head;
                    second=b;
                }
                else
                {
                    b.next=head;
                    b=b.next;
                }
            }
            head=head.next;
        }
        if(first==null)
            return second;
        if(second==null)
            return first;
        a.next=null;
        b.next=null;
        a=first;
        while(a.next!=null)
            a=a.next;
        a.next=second;
        return first;
    }
}
