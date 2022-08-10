/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        return insert(head,null);
    }
    
    private TreeNode insert(ListNode low,ListNode high)
    {
        if(low==high)
            return null;
        ListNode slow = low;
        ListNode fast = low;
        
        while(fast!=high&&fast.next!=high)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        root.left = insert(low,slow);
        root.right = insert(slow.next,high);
        return root;
    }
}
