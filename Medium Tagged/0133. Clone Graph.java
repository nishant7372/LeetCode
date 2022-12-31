// 25ms runtime, Faster than 99.5%   --> Optimized Approach

class Solution {
    boolean[] visited;
    Map<Node,Node> map1;
    public Node cloneGraph(Node node) {
        visited=new boolean[101];
        map1=new HashMap<>();
        dfs(node);

        for(Node currNode:map1.keySet())
        {
            List<Node> neighbors = currNode.neighbors;
            List<Node> newNodeNeighbors = new ArrayList<Node>();
            for(Node neighbor: neighbors)
            {
                newNodeNeighbors.add(map1.get(neighbor));
            }
            map1.get(currNode).neighbors = newNodeNeighbors;
        }
        return map1.get(node);
    }

    private void dfs(Node node)
    {
        if(node==null || visited[node.val])
            return;
        Node newNode = new Node(node.val);
        map1.put(node,newNode);
        visited[node.val]=true;
        for(Node neighbor:node.neighbors){
            dfs(neighbor);
        }
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
