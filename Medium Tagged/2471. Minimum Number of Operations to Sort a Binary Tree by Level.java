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
    public int minimumOperations(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        dfs(root,list,0);
        int sum=0;
        for(ArrayList<Integer> temp:list)
        {
          sum+=minSwaps(temp);     
        }
        return sum;
    }

    public static int minSwaps(ArrayList<Integer> temp)
    {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<temp.size();i++)
            map.put(temp.get(i), i);
             
        Collections.sort(temp);  
         
        boolean[] visited = new boolean[temp.size()];
         
        int ans = 0;
        for(int i=0;i<temp.size();i++) {
           
            if(visited[i] || map.get(temp.get(i))==i)
                continue;
                 
            int j = i, cycle = 0;
            while(!visited[j]) {
                visited[j] = true;
                 
                j = map.get(temp.get(j));
                cycle++;
            }
             
            if(cycle > 0) {
                ans += (cycle - 1);
            }
        }
        return ans;
    }
    
    private void dfs(TreeNode root,ArrayList<ArrayList<Integer>> list,int l)
    {
        if(root==null)
            return;
        if(list.size()==l)
            list.add(new ArrayList<>());
        list.get(l).add(root.val);
        dfs(root.left,list,l+1);
        dfs(root.right,list,l+1);
    }
}
