public class Solution {
    public ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while(list.indexOf(head)==-1&&head!=null)
        {
            list.add(head);
            head=head.next;
        }
        return head;
    }
}
