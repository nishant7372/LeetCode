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
    
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        dfs(root,map,root);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited.add(start);
        int c=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int curr = queue.remove();
                for(int x:map.get(curr)){
                    if(!visited.contains(x)){
                        queue.add(x);
                        visited.add(x);
                    }
                }
            }
            c++;
        }
        return c-1;
    }
    
    private void dfs(TreeNode root,Map<Integer,ArrayList<Integer>> map,TreeNode parent)
    {
        if(root==null)
            return;
        ArrayList<Integer> list = new ArrayList<>();
        if(root!=parent)
            list.add(parent.val);
        if(root.left!=null)
            list.add(root.left.val);
        if(root.right!=null)
            list.add(root.right.val);
        map.put(root.val,list);
        dfs(root.left,map,root);
        dfs(root.right,map,root);
    }
}
