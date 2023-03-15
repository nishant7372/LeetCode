// Method 1 -> DFS
// O(n) time and O(1) space
// 0ms runtime, Beats 100%

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode temp1, TreeNode temp2){
        if(temp1==null || temp2 == null){
            return temp1==temp2;
        }
        if(temp1.val!=temp2.val){
            return false;
        }
        return isSymmetric(temp1.left, temp2.right) && isSymmetric(temp1.right, temp2.left);
    }
}

// Method 2 -> DFS
// O(2*n) time and O(n) space
// 1ms runtime, Beats 17.57%

class Solution {
    public boolean isSymmetric(TreeNode root) {
    ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        dfs(root,0,a);
        
        for(ArrayList<Integer> list : a)
        {
            int j=0, k=list.size()-1;
            while(j<k)
            {
                if(list.get(j++)!=list.get(k--))
                    return false;
            }
        }
        return true;
    }
    
    private void dfs(TreeNode root,int c,ArrayList<ArrayList<Integer>> a)
    {
        if(a.size()==c)
            a.add(new ArrayList<Integer>());
        if(root==null){
            a.get(c).add(null);
            return;
        } 
        a.get(c++).add(root.val);
        dfs(root.left,c,a);
        dfs(root.right,c,a);
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
