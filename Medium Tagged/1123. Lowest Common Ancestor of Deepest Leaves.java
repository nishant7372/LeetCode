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
    int[][] a;
    int maxLevel=0;
    TreeNode[] map;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        a = new int[1001][2];
        ArrayList<Integer> list = new ArrayList<>();
        map= new TreeNode[1001];
        dfs(root,1,root);
        
        for(int i=0;i<a.length;i++)
        {
            if(a[i][0]==maxLevel)
                list.add(i);
        }
        if(list.size()==1)
            return map[list.get(0)];
        int ans = solve(list.get(0),list.get(1));
        for(int i=2;i<list.size();i++)
        {
            ans = solve(ans,list.get(i));
        }
        return map[ans];
    }
    
    private int solve(int x,int y)
    {
        while(x!=y)
        {
            if(a[x][0]>a[y][0])
                x=a[x][1];
            else
                y=a[y][1];
        }
        return x;
    }
    
    private void dfs(TreeNode root,int level,TreeNode parent)
    {
        if(root==null)
            return;
        a[root.val][0]=level;
        if(level>maxLevel)
            maxLevel=level;
        a[root.val][1]=parent.val;
        map[root.val]=root;
        dfs(root.left,level+1,root);
        dfs(root.right,level+1,root);
    }
}
