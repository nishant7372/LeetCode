//Method 1--> Using Stack

class Solution {
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        Stack<Node> st = new Stack<>();
        if(root==null)
           return a;
        st.add(root);
              
        while(!st.isEmpty())
        {
            Node curr = st.pop();
            a.add(curr.val);
            List<Node> list = new ArrayList<>();
            for(Node child:curr.children)
                list.add(child);
            
            for(int i=list.size()-1;i>=0;i--)
                st.add(list.get(i));
            
        }
        return a;
    }
}


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
