//Approach 1 -> 2ms runtime Faster than 100%

class Solution {
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        inorder(root,values,nodes);
        TreeNode node1=null;
        for(int i=0;i<values.size()-1;i++){
            if(values.get(i)>values.get(i+1)){
               node1 = nodes.get(i); //1st incorrect node
               break;
            }
        }
        for(int i=values.size()-1;i>=1;i--){
            if(values.get(i)<values.get(i-1)){
               swap(node1,nodes.get(i));//2nd incorrect node & swapping values
               break;
            }
        }
       
    }
    
    private void inorder(TreeNode root,ArrayList<Integer> values,ArrayList<TreeNode> nodes)
    {
        if(root==null)
            return;
        inorder(root.left,values,nodes);
        values.add(root.val);
        nodes.add(root);
        inorder(root.right,values,nodes);
    }
    
    private void swap(TreeNode temp1,TreeNode temp2)
    {
        int temp = temp1.val;
        temp1.val = temp2.val;
        temp2.val = temp;
    }
}

//Approach 2 -> Using one list only. (4ms runtime, Faster than 28%)

class Solution {
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        inorder(root,list);
        TreeNode node1=null;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i).val>list.get(i+1).val){
               node1 = list.get(i); //1st incorrect node
               break;
            }
        }
        for(int i=list.size()-1;i>0;i--){
            if(list.get(i).val<list.get(i-1).val){
               swap(node1,list.get(i)); //2nd incorrect node & swapping of values
               break;
            }
        }
    }
    
    private void inorder(TreeNode root,ArrayList<TreeNode> list)
    {
        if(root==null)
            return;
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }
    
    private void swap(TreeNode temp1,TreeNode temp2)
    {
        int temp = temp1.val;
        temp1.val = temp2.val;
        temp2.val = temp;
    }
}


//Approach 3 -> Using Sorting (3ms runtime, Fater than 51%)

class Solution {
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<TreeNode> b = new ArrayList<TreeNode>();
        inorder(root,a,b);
        Collections.sort(a);
        TreeNode node1=null, node2=null;
        for(int i=0;i<a.size();i++){
            if(a.get(i)!=b.get(i).val){
            node1 = b.get(i);
            break;
            }
        }
        for(int i=a.size()-1;i>=0;i--){
            if(a.get(i)!=b.get(i).val){
            node2 = b.get(i);
            break;
            }
        }
        swap(node1,node2);
    }
    
    private void inorder(TreeNode root,ArrayList<Integer> a,ArrayList<TreeNode> b)
    {
        if(root==null)
            return;
        inorder(root.left,a,b);
        a.add(root.val);
        b.add(root);
        inorder(root.right,a,b);
    }
    
    private void swap(TreeNode temp1,TreeNode temp2)
    {
        int temp = temp1.val;
        temp1.val = temp2.val;
        temp2.val = temp;
    }
}


//Approach 4 -> Custom Sort Logic using Flags (3ms runtime, Fater than 51%)

class Solution {
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<TreeNode> b = new ArrayList<TreeNode>();
        inorder(root,a,b);
        boolean flag = false;
        for(int k=0;k<a.size();k++)
        {
        int i=k;
        int j=a.size()-1;
        while(i<j)
        {
            if(a.get(i)>a.get(j))
            {
                flag=true;
            swap(b.get(i),b.get(j));
            int temp =a.get(i);
            a.set(i,a.get(j));
            a.set(j,temp);
                break;
            }
            j--;
        }
            if(flag==true)
                break;
        }
    }
    
    private void inorder(TreeNode root,ArrayList<Integer> a,ArrayList<TreeNode> b)
    {
        if(root==null)
            return;
        inorder(root.left,a,b);
        a.add(root.val);
        b.add(root);
        inorder(root.right,a,b);
    }
    
    private void swap(TreeNode temp1,TreeNode temp2)
    {
        int temp = temp1.val;
        temp1.val = temp2.val;
        temp2.val = temp;
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
