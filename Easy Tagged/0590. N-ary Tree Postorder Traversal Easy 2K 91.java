//Approach 1 --> Using Stack

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
