class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0,head);
        
        ListNode dummy = sentinel;
        
        while(head!=null)
        {
            if(head.next!=null && head.val == head.next.val)
            {
                while(head.next!=null && head.val == head.next.val)
                    head=head.next;
                 dummy.next=head.next;
            }
            else
            {
                dummy=dummy.next;
            }
            head = head.next;
        }
        return sentinel.next;
    }
}
