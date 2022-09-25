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
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] a = new int[m][n];
        
        for(int[] temp:a)
            Arrays.fill(temp,-1);
        
        int i=0;
        int j=0;
        while(i<m && j<n && a[i][j]==-1 && head!=null){
            
        //left -> right
            while(j<n&&a[i][j]==-1&&head!=null){
                a[i][j++]=head.val;
                head = head.next;
            }
           j--;
           i++;
        //top -> bottom
            while(i<m&&a[i][j]==-1&&head!=null){
                a[i++][j]=head.val;
                head=head.next;
            }
           i--;
           j--;
        //right -> left
            while(j>-1&&a[i][j]==-1&&head!=null){
                a[i][j--]=head.val;
                head= head.next;
            }
           i--;
           j++;
        
        // bottom -> top
            while(i>-1&&a[i][j]==-1&&head!=null){
                a[i--][j]=head.val;
                head = head.next;
            }
            i++;
            j++;
        }
        return a;
    }
}
