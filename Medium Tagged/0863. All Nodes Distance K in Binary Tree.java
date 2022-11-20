/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Integer[] map;
	Integer[] map2;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        map = new Integer[501];
		map2 = new Integer[502];
        dfs(root,0,root);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<map.length;i++)
        {
            if(map[i]==null)
                continue;
            if(isDistk(i,target.val,k))
                list.add(i);
        }
        return list;
    }
    
    private boolean isDistk(int x, int y,int k) {
		int c=0;
		while(x!=y)
		{
			if(map[x]>map[y])
			x=map2[x];
			else
			y=map2[y];
			c++;
		}
		return c==k? true:false;
    }
	
	private void dfs(TreeNode root,int level,TreeNode parent)
	{
		if(root==null)
            return;
		map[root.val]=level;
		map2[root.val]=parent.val;
		dfs(root.left,level+1,root);
		dfs(root.right,level+1,root);
	}
}
