class Solution {
    private int[][] properties;
    private boolean[] visited;
    private List<Set<Integer>> adj;

    private int intersect(int i , int j){
        int common = 0;
        Set<Integer> distinct = new HashSet<>();
        for(int x : properties[i]){
            if(distinct.contains(x)) continue;
            distinct.add(x);
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
        for(int nei : adj.get(node)){
            if(!visited[nei]) visit(nei);
        }
    }

    public int numberOfComponents(int[][] properties, int k) {
        final int n = properties.length;
        this.properties = properties;
        adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new HashSet<>());

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j) continue;
                if(intersect(i,j) >= k){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
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