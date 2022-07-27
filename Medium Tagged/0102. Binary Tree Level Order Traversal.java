![image](https://assets.leetcode.com/users/images/70c167f6-4af7-4e6a-aede-a44490a0cb54_1658934718.0628078.png)

```java 
//Depth First Search
class Solution {
    private List<List<Integer>> a;
    public List<List<Integer>> levelOrder(TreeNode root) {
        a = new ArrayList<List<Integer>>();
        traverse(root,0);
        return a;
    }
    
    private void traverse(TreeNode root,int c)
    {
        if(root==null)
            return;
        if(a.size()<=c)
            a.add(new ArrayList<Integer>());
        a.get(c).add(root.val);
        traverse(root.left,c+1);
        traverse(root.right,c+1);
    }
}


//Breadth First Search
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        List<List<Integer>> a= new ArrayList<List<Integer>>();
        if(root!=null)
        q.add(root);
        int j=0;
        while(!q.isEmpty())
        {
            int c=q.size(); 
            a.add(new ArrayList<Integer>());
            for(int i=0;i<c;i++)
            {
                TreeNode presentNode = q.remove();
                a.get(j).add(presentNode.val);
                if(presentNode.left!=null)
                    q.add(presentNode.left);
                if(presentNode.right!=null)
                    q.add(presentNode.right);
            }
            j++;
        }
        return a;
    }
}
