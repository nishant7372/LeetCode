//Using Stack - Iterative
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root!=null)
           st.push(root);
        while(!st.isEmpty()){
           TreeNode curr = st.pop();
           list.add(curr.val);
           if(curr.right!=null)
               st.push(curr.right);
           if(curr.left!=null)
               st.push(curr.left);
        }
        return list;
    }
}

/*-----------------------------------------------------------------------------------------------------------------------*/

//Recursive - Naive/Trivial
class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)
            return list;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}
