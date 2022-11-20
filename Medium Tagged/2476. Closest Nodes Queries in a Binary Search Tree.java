/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        ArrayList<Integer> list = new ArrayList<>();
        traverse(root,list);
        
        List<List<Integer>> res = new ArrayList<>();
        for(int x:queries)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            int idx = Collections.binarySearch(list,x);
            if(idx>=0)
            {
                temp.add(x);
                temp.add(x);
            }
            else
            {
                idx = -1*(idx+1);
                if(idx<list.size() && idx>=0)
                    temp.add(list.get(idx));
                else
                    temp.add(-1);
                idx--;
                if(idx<list.size() && idx>=0)
                    temp.add(list.get(idx));
                else
                    temp.add(-1);
                
            }
            Collections.reverse(temp);
            res.add(temp);
        }
        return res;
    }
    
    private void traverse(TreeNode root,ArrayList<Integer> list)
    {
        if(root==null)
            return;
        traverse(root.left,list);
        list.add(root.val);
        traverse(root.right,list);
    }
    
}
