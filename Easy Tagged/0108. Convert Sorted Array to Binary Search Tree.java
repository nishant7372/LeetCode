class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = insert(0,nums.length-1,nums);
        return root;
    }
    
    
    private TreeNode insert(int low,int high,int[] nums)
    {
        if(low>high)
            return null;
        int mid=(low+high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = insert(low,mid-1,nums);
        root.right = insert(mid+1,high,nums);
        return root;
    }
}
