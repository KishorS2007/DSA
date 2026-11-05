class Solution {
    private int[][] properties;
    private boolean[] visited;
    // private List<List<Integer>> adj;
    private boolean[][] adj = new boolean[101][101];

    private int intersect(int i , int j){
        int common = 0;
        boolean[] distinct = new boolean[101];

        for(int x : properties[i]){
            if(distinct[x]) continue;
            distinct[x] = true;

            for(int y : properties[j]){
                if(x == y){
                    common++;
                    break;
                }
            }
        }

        return common;
    }

    private void visit(int node){
        visited[node] = true;
        // for(int nei : adj.get(node)){
        //     if(!visited[nei]) visit(nei);
        // }
        for(int nei = 0 ; nei < 101 ; nei++){
            if(adj[node][nei] && !visited[nei]) visit(nei);
        }
    }

    public int numberOfComponents(int[][] properties, int k) {
        final int n = properties.length;
        this.properties = properties;
        // adj = new ArrayList<>();
        // for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j) continue;
                if(intersect(i,j) >= k){
                    // adj.get(i).add(j);
                    // adj.get(j).add(i);
                    adj[i][j] = true;
                    adj[j][i] = true;
                }
            }
        }

        int components = 0;
        visited = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                components++;
                visit(i);
            }
        }

        return components;
    }
}