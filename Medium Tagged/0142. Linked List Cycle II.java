/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//Floyd Cycle Detection Algorithm -> Optimized Solution

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                break;
        }
        if(fast==null || fast.next==null)
            return null;
        while(slow!=head)
        {
            slow = slow.next;
            head = head.next;
        }
        return head;
    }
}


//Brute Force

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
