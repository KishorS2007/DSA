import java.util.*;
import java.util.function.*;
class Solution {
    private int[][] properties;
    private boolean[] visited;
    private List<List<Integer>> adj;

    private int intersect(int i , int j){
        Set<Integer> s1 = new HashSet<>() , s2 = new HashSet<>();

        for(int k = 0 ; k < properties[0].length ; k++){
            s1.add(properties[i][k]);
            s2.add(properties[j][k]);
        }

        int count = 0;
        for(int num : s1){
            if(s2.contains(num)) count++; 
        }

        return count;
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