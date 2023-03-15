// Method 1 -> Priority Queue
// 5ms runtime, Beats 68%

 class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((l1,l2)->l1.val-l2.val);

        for(ListNode temp:lists){
            if(temp!=null)
            queue.add(temp);
        }
        
        ListNode sentinel = new ListNode(0);
        ListNode temp = sentinel;
        while(!queue.isEmpty()){
            ListNode curr = queue.remove();
            temp.next=curr;
            temp=temp.next;

            if(curr.next!=null){
                queue.add(curr.next);
            }
        }

        return sentinel.next;
    }
}

// Method 2 -> Sorting
// 8ms runtime, Beats 28%

 class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ListNode> list = new ArrayList<>();
        for(ListNode temp:lists)
            traverse(temp,list);
        
        Collections.sort(list, (l1,l2)->l1.val-l2.val);
        
        if(list.size()==0){
            return null;
        }

        ListNode temp=list.get(0);
        for(int i=1;i<list.size();i++){
            temp.next=list.get(i);
            temp=temp.next;
        }
        return list.get(0);
    }
    
    private void traverse(ListNode temp, ArrayList<ListNode> list)
    {
        while(temp!=null)
        {
            list.add(temp);
            temp=temp.next;
        }
    }
}

// Method 3 -> Sorting
// 11ms runtime, Beats 20%

class Solution {
    ListNode root;
    ListNode front;
    ListNode rear;
    public ListNode mergeKLists(ListNode[] lists) {
        root=null;
        front=null;
        rear=null;
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(ListNode temp:lists)
            traverse(temp,a);
        
        Collections.sort(a);
        
        for(int x:a)
            append(x);
        return root;
    }
    
    private void traverse(ListNode temp, ArrayList<Integer> a)
    {
        while(temp!=null)
        {
            a.add(temp.val);
            temp=temp.next;
        }
    }
    
    private void append(int val)
    {
        ListNode temp = new ListNode(val,null);
        
        if(front==rear)
        {
            root=temp;
            rear=temp;
        }
        else
        {
            rear.next=temp;
            rear=temp;
        }
    }
}

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
