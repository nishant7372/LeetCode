// Approach 1 -  Inorder Recursive Traversal and Comparison with previous Element  --> 1ms runtime

class Solution {
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode root)
    {
        if(root==null)
            return true;
        boolean b1 = inorder(root.left);
        if(prev!=null&&root.val<=prev)
            return false;
        prev = root.val;
        boolean b2 = inorder(root.right);
        return b1&&b2;
    }
}

//Approach 2 - Checking the sorted list  --> 1ms runtime

class Solution {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        func(root,a);
        for(int i=0;i<a.size()-1;i++)
            if(a.get(i)>=a.get(i+1))
                return false;
        return true;
    }
    
    static void func(TreeNode root, ArrayList<Integer> a)
    {
        if(root==null)
            return;
        func(root.left,a);
        a.add(root.val);
        func(root.right,a);
    }
}

//Approach 3 - Breadth First search and Comparison of root with maximum and minimum element respectively  --> 2ms runtime

class Solution {
    public boolean isValidBST(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.remove();
            if(temp.left!=null)
            {
                if(max(temp.left)>=temp.val)
                    return false;
                queue.add(temp.left);
            }
            if(temp.right!=null)
            {
                if(min(temp.right)<=temp.val)
                    return false;
                queue.add(temp.right);    
            }
        }
        return true;
    }
    
    
    private int min(TreeNode root)
    {
        while(root.left!=null)
        {
            root=root.left;
        }
        return root.val;
    }
    
    private int max(TreeNode root)
    {
        while(root.right!=null)
        {
            root=root.right;
        }
        return root.val;
    }
}
