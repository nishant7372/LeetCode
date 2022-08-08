class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> a = new ArrayList<List<Integer>>();
        generate(a,new ArrayList<Integer>(),root,targetSum);
        return a;
    }
    
    private void generate(List<List<Integer>> a,ArrayList<Integer> temp,TreeNode root,int targetSum)
    {
        if(root==null)
            return;
        
        if(isLeaf(root))
        {
            if(targetSum==root.val)
            {
                temp.add(root.val);
                a.add(new ArrayList<Integer>(temp));
                temp.remove(temp.size()-1);
            }
            return;
        }
        temp.add(root.val);
        generate(a,temp,root.left,targetSum-root.val);
        generate(a,temp,root.right,targetSum-root.val);
        temp.remove(temp.size()-1);
    }
    
    private boolean isLeaf(TreeNode root)
    {
        if(root.left==null&&root.right==null)
            return true;
        return false;
    }
}
