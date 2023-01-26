//Method 1--> DFS (Depth First Search)

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(Node root) {
        res = new ArrayList<List<Integer>>();
        traverse(root,0);
        return res;
    }
    
    private void traverse(Node root,int i)
    {
        if(root==null){
            return;
        }
        if(i==res.size()){
            res.add(new ArrayList<Integer>());
        }
        res.get(i).add(root.val);
        for(Node child:root.children){
            traverse(child,i+1);
        }
    }
}

//Method 2 --> BFS (Breadth First Search)

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root!=null){
           queue.add(root);
        }
        
        while(!queue.isEmpty())
        {
            int len = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while(len-->0)
            {
                Node currNode = queue.remove();
                list.add(currNode.val);
                for(Node child: currNode.children){
                    queue.add(child);
                }
            }
            res.add(list);
        }
        return res;
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
