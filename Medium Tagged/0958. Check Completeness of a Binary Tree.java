// Method 1 -> BFS 
// 1ms runtime, Beats 83.3%

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        return bfs(root);
    }

    private boolean bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(curr==null){
                while(!queue.isEmpty()){
                    if(queue.remove()!=null)
                       return false;
                }
                return true;
            }
            queue.add(curr.left);
            queue.add(curr.right);
        }
        return true;
    }
}

// Method 2 -> Counting
// 1ms runtime, Beats 83.3%

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        return nodeCount(root)+1 == bfsCount(root);
    }

    private int bfsCount(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        int count=0;
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            count++;
            if(curr.left!=null){
                queue.add(curr.left);
            }
            else{
                return count+queue.size();
            }
            if(curr.right!=null){
                queue.add(curr.right);
            }
            else{
                return count+queue.size();
            }
        }
        return count+queue.size();
    }

    private int nodeCount(TreeNode root){
        if(root==null){
            return -1;
        }
        return nodeCount(root.left) + nodeCount(root.right) + 2;
    }
}
