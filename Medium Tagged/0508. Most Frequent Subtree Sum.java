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
    int max; //maxFreq
    public int[] findFrequentTreeSum(TreeNode root) {
        max=0;
        Map<Integer,Integer> map = new HashMap<>();
        dfs(root,map);
        ArrayList<Integer> list = new ArrayList<>();
        for(var entry:map.entrySet())
        {
            if(entry.getValue()==max)
                list.add(entry.getKey());
        }
        int[] res = new int[list.size()];
        int i=0;
        for(int x:list)
            res[i++]=x;
        return res;
    }
    
    private int dfs(TreeNode root,Map<Integer,Integer> map)
    {
        if(root==null)
            return 0;
        int lSum = dfs(root.left,map);
        int rSum = dfs(root.right,map);
        int sum=lSum+rSum+root.val;
        map.put(sum,map.getOrDefault(sum,0)+1);
        if(map.get(sum)>max)
            max=map.get(sum);
        return sum;
    }
}
