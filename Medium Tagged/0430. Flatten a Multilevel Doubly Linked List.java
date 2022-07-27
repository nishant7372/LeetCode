class Solution {
    private List<Node> list = new ArrayList<>();
    public Node flatten(Node head) {
        traverse(head);
        Node temp = head;
        for(int i=1;i<list.size();i++)
        {
            temp.next=list.get(i);
            temp.child=null;
            list.get(i).prev=temp;
            temp=temp.next;
        }
        return head;
    }
    
    private void traverse(Node head)
    {
        if(head==null)
            return;
        list.add(head);
        traverse(head.child);
        traverse(head.next);
    }
}
