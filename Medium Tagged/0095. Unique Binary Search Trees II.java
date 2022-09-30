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
    List<List<Integer>> preOrderList;
    public List<TreeNode> generateTrees(int n) {
        
        List<TreeNode> res = new ArrayList<>();
        preOrderList = new ArrayList<>();
        find(n,res,new ArrayList<Integer>());
        return res;
    }
    
    private void find(int n,List<TreeNode> res,ArrayList<Integer> list)
    {
        if(list.size()==n){
            TreeNode root = built(list);
            ArrayList<Integer> temp = preOrder(root,new ArrayList<Integer>());
            if(preOrderList.indexOf(temp)==-1)
            {
                res.add(root);
                preOrderList.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        for(int i=1;i<=n;i++){
            if(list.indexOf(i)==-1){
                list.add(i);
                find(n,res,list);
                list.remove(list.size()-1);
            }
        }
    }
    
    //Making a binary Search Tree
    private TreeNode built(ArrayList<Integer> list)
    {
        TreeNode root = new TreeNode(list.get(0));
        for(int i=1;i<list.size();i++)
        {
            TreeNode temp = new TreeNode(list.get(i));
            addNode(root,temp,root);
        }
        return root;
    }
    
    //addition of a node to a binary search tree
    private void addNode(TreeNode root,TreeNode temp,TreeNode parent)
    {
        if(root==null)
        {
            if(temp.val<parent.val)
                parent.left = temp;
            else
                parent.right = temp;
            return;
        }
        if(root.val>temp.val)
            addNode(root.left,temp,root);
        else
            addNode(root.right,temp,root);
    }
    
    //PreOrder Traversal to avoid structurally same tree 
    private ArrayList<Integer> preOrder(TreeNode root,ArrayList<Integer> list)
    {
        if(root==null)
            return list;
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list); 
        return list;
    }                              
}
