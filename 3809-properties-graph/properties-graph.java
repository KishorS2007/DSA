import java.util.*;
import java.util.function.*;
class Solution {
    private int[][] properties;
    private boolean[] visited;
    private List<List<Integer>> adj;

    private int intersect(int i , int j){
        Set<Integer> s = Arrays.stream(properties[i])
                        .boxed()
                        .collect(Collectors.toSet());

        return (int) Arrays.stream(properties[j])
                .distinct()
                .filter(x -> s.contains(x))
                .count();
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
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());

        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
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