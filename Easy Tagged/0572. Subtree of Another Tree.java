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

//Method 1
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        if(root.val==subRoot.val && isIdentical(root,subRoot))
            return true;
        if(isSubtree(root.left,subRoot))
            return true;
        return isSubtree(root.right,subRoot);
    }
    
    private boolean isIdentical(TreeNode root,TreeNode subRoot)
    {
        if(root==null && subRoot==null)
            return true;
        if(root==null || subRoot==null)
            return false;
        if(root.val!=subRoot.val)
            return false;
        if(!isIdentical(root.left,subRoot.left))
            return false;
        return isIdentical(root.right,subRoot.right);
    }
}




//Method 2 -> Comparing PreOrder and InOrder Traversal

class Solution {
    boolean res=false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
          inorder(subRoot,a);
          preOrder(subRoot,b);
          traverse(root,a,b);
              return res;
    }
    
    private void traverse(TreeNode root,ArrayList<Integer> a,ArrayList<Integer> b)
    {
        if(root==null)
            return;
        traverse(root.left,a,b);
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        inorder(root,list);
        preOrder(root,list2);
        if(a.equals(list)&&b.equals(list2))
            res=true;
        traverse(root.right,a,b);
    }

    
    private void inorder(TreeNode root, ArrayList<Integer> list)
    {
        if(root==null)
            return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    
    private void preOrder(TreeNode root, ArrayList<Integer> list)
    {
        if(root==null)
            return;
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }
}
