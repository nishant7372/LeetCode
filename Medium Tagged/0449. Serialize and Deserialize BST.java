/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        sb.append("(");
        if(root!=null){
        sb.append(root.val);
        queue.add(root);
        }
        sb.append(")");
        while(!queue.isEmpty())
        {
            TreeNode currNode = queue.remove();
            sb.append("(");
            if(currNode.left!=null){
                sb.append(currNode.left.val);
                queue.add(currNode.left);
            }
            sb.append(")");
            sb.append("(");
            if(currNode.right!=null){
                sb.append(currNode.right.val);
                queue.add(currNode.right);
            }
            sb.append(")");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayList<Integer> a = new ArrayList<>();
        int j=1;
        for(int i=0;i<data.length();i++)
        {
            if(data.charAt(i)==')'){
                if(j!=i){
                a.add(Integer.parseInt(data.substring(j,i)));
                }
                else
                a.add(null);
                j=i+2;
            }
        }
        int i=1;
        if(a.get(0)==null)
            return null;
        TreeNode root = new TreeNode(a.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode currNode = queue.remove();
            if(a.get(i)!=null){
                currNode.left=new TreeNode(a.get(i));
                queue.add(currNode.left);
            }
            else
                currNode.left=null;
            i++;
            if(a.get(i)!=null){
                currNode.right=new TreeNode(a.get(i));
                queue.add(currNode.right);
            }
            else
                currNode.right=null;
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
