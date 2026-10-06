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
   
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        
        Node newNode;
        map.put(node , newNode = new Node(node.val));

        // make connections
        for(Node neiNode : node.neighbors){
            if(map.containsKey(neiNode)){
                newNode.neighbors.add(map.get(neiNode));
            } else {
                newNode.neighbors.add(cloneGraph(neiNode));
            }
        }

        return newNode;
    }
}