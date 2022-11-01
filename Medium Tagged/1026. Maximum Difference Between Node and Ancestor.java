// Approach used:
// The approach is to find the maximum of differences of max and min values in every path from root to leaf nodes.

// Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
// Output: 7

// Path 1 -> 8->3->1 [min=1 max=8] , max-min=7 , v=7
// Path 2 -> 8->3->6->4 [min=3 max=8] , max-min=5 ,v=7
// Path 3 -> 8->3->6->7 [min=3 max=8] , max-min=5 ,v=7
// Path 4 -> 8->10->14->13 [min=8 max=13] , max-min=5 ,v=7

// Also, v= maximum of (7,5,5,5) = 7

class Solution {
    int v;
    public int maxAncestorDiff(TreeNode root) {
        v=0;
        dfs(root,0,100000);
        return v;
    }
    
    private void dfs(TreeNode root,int max,int min)
    {
        if(root==null)
        {
            v=Math.max(v,max-min);  // updating v on reaching leaf nodes will also give same result
            return;
        }
        if(root.val<min)
            min=root.val;
        if(root.val>max)
            max=root.val;
        dfs(root.left,max,min);
        dfs(root.right,max,min);
    }
}
