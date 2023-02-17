// Method 1 -> 0ms runtime Beats 100%
// Inorder Traversal 
// Time -> O(n)
// Space -> O(1)

class Solution {
    int absDiff=Integer.MAX_VALUE;
    TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return absDiff;
    }

    private void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        if(prev!=null){
            absDiff = Math.min(absDiff,root.val-prev.val);
        }
        prev = root;
        inOrder(root.right);
    }
}

// Method 2 -> 1ms runtime Beats 27%
// Inorder Traversal + List
// Time -> O(n)
// Space -> O(n)

class Solution {
    static ArrayList<Integer> a;
    public int minDiffInBST(TreeNode root) {
        a=new ArrayList<Integer>();
        inorder(root);
        int min = a.get(1)-a.get(0);
        for(int i=1;i<a.size()-1;i++)
            min = Math.min(min,a.get(i+1)-a.get(i));
        return min;
    }
    
    static void inorder(TreeNode root)
    {
        if(root==null)
            return;
        inorder(root.left);
        a.add(root.val);
        inorder(root.right);
    }
}

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
