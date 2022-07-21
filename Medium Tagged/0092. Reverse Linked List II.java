class Solution {
    public ListNode reverseBetween(ListNode root, int left, int right) {
	        ListNode temp=root;
	        ListNode temp1=root;
	        int i=left-1;
	        int j=right-1;
            int c=0;
            while(c<i)
            {
             temp=temp.next;
             c++;
            }
	        while(i<j)
	        {
	            int k=0;
	            while(k<j)
	            {
	            	temp1=temp1.next;
	                k++;
	            }
                
	            int a = temp.val;
	            temp.val=temp1.val;
	            temp1.val=a;
	            i++;
	            j--;
	            temp=temp.next;
	            temp1=root;
	        }
        return root;
	    }
    }
