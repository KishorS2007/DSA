class Solution {
    boolean[] visited;
    List<List<Integer>> adj = new ArrayList<>();
    public int countCompleteComponents(int n, int[][] edges) {
        visited = new boolean[n];
        for(int i = 0; i < n ; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int completeComponents = 0;
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                int[] nodeAndEdge = {0,0};
                dfs(i,nodeAndEdge);
                if(nodeAndEdge[1] == nodeAndEdge[0] * (nodeAndEdge[0]-1))
                    completeComponents++;
            }
        }

        return completeComponents;
    }

    private void dfs(int node,int[] nodeAndEdge){
        visited[node] = true;
        
        nodeAndEdge[0]++; // 0 => node , 1 => edge
        nodeAndEdge[1] += adj.get(node).size();

        for(int nei : adj.get(node)){
            if(visited[nei]) continue;
            dfs(nei,nodeAndEdge);
        }

    }
}