/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Map<Node,Node> map = new HashMap<>();
        Node root=null;
        Node newNode = new Node(head.val);
        map.put(newNode,head);
        map.put(head,newNode);
        head=head.next;
        root=newNode;
        while(head!=null)
        {
            newNode.next=new Node(head.val);
            newNode=newNode.next;
            map.put(newNode,head);
            map.put(head,newNode);
            head = head.next;
        }
        
        Node temp = root;
        while(temp!=null)
        {
            temp.random = map.get(map.get(temp).random);
            temp=temp.next;
        }
        return root;
    }
}
