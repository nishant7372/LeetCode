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
    static int[] a;
    public int[] findMode(TreeNode root) {
        a = new int[200001];
        preorder(root);
        int max=0;
        for(int x:a)
            if(max<x)
            max=x;
        int c=0;
        int last =0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]!=0)
                last=i;
            if(a[i]==max)
                c++;
        }
        int k=0;
        int[] b = new int[c];
        for(int i=0;i<=last;i++)
        {
            if(a[i]==max)
            {
                b[k]=i-100000;
                k++;
            }
        }
        return b;
    }
    
    static void preorder(TreeNode root)
    {
        if(root==null)
            return;
        a[root.val+100000]++;
        preorder(root.left);
        preorder(root.right);
    }
}
