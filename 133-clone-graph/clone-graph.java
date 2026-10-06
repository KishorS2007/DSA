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

class Solution {
    Map<Node , Node> map = new HashMap<>();
    Set<Node> visited = new HashSet<>();

    private void dfs(Node node){
        Node newThis = map.computeIfAbsent(node , _ -> new Node(node.val));
        visited.add(node);

        // make connections
        for(Node neiNode : node.neighbors){
            Node newNei = map.computeIfAbsent(neiNode, _ -> new Node(neiNode.val));
            newThis.neighbors.add(newNei);
            
            if(visited.contains(neiNode)) continue;
            dfs(neiNode);

        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return node;

        dfs(node);
        return map.get(node);
    }
}