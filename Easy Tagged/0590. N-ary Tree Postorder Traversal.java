//Approach 1 --> Using Stack

class Solution {
    public List<Integer> postorder(Node root) {
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
                st.add(child);
        }
        Collections.reverse(a);
        return a;
    }
}

//Approach 2 --> Recursion

class Solution {
    ArrayList<Integer> a  = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        if(root==null)
            return a;
        for(Node temp:root.children)
            postorder(temp);
        a.add(root.val);
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
