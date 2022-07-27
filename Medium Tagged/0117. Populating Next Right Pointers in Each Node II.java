class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root!=null)
        q.add(root);
        while(!q.isEmpty())
        {
            int c=q.size();
            for(int i=0;i<c;i++)
            {
                Node presentNode = q.remove();
                if(i<c-1)
                    presentNode.next=q.peek();
                if(presentNode.left!=null)
                    q.add(presentNode.left);
                if(presentNode.right!=null)
                    q.add(presentNode.right);
            }
        }
        return root;
    }
}
