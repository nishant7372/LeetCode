class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int[] a = new int[k];
        ListNode temp1 = head;
        ListNode temp2 = head;
        int len = length(head,0);
        int c=0;
        int m=0;
        while(len/k!=m)
        {
        while(c!=k)
        {
            a[c++]=temp1.val;
            temp1=temp1.next;
        }
        while(c!=0)
        {
            temp2.val = a[--c];
            temp2=temp2.next;
        }
            m++;
        }
        return head;
    }
    
    private int length(ListNode head,int c)
    {
        if(head==null)
            return c;
        return length(head.next,c+1);
    }
}
