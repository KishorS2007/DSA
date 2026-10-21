import java.util.*;
class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    // boolean[] isNotPossible;
    String colors;

    // 'R' -> 'B' -> 'W' -> 'R'
    Map<Character,Character> nextColor = Map.ofEntries(
        Map.entry('R','B'),
        Map.entry('B','W'),
        Map.entry('W','R')
    );

    private boolean isRoot(int node , int parent){
        if(adj.get(node).size() > 2){
            // isNotPossible[node] = true;
            return false;
        }
        
        boolean[] visited = new boolean[adj.size()];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{node,parent});

        visited[node] = true;
        int count = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currNode = curr[0] , currParent = curr[1];
            char rootColor = colors.charAt(currNode);

            for(int nei : adj.get(currNode)){
                if(nei == currParent || visited[nei]) continue;
                char neiColor = colors.charAt(nei);

                if(nextColor.get(rootColor) != neiColor){
                    // isNotPossible[node] = true;
                    return false;
                }

                visited[nei] = true;
                q.offer(new int[]{nei,currNode});
                count++;
            }
        }

        return count == adj.size();
    }
    // private boolean isRoot(int node , int parent){
    //     // edge case
    //     if(parent == -1 && adj.get(node).size() > 2){
    //         isNotPossible[node] = true;
    //         return false;
    //     }

    //     char rootColor = colors.charAt(node);

    //     for(int nei : adj.get(node)){
    //         if(nei == parent) continue;

    //         char neiColor = colors.charAt(nei);
    //         if(nextColor.get(rootColor) == neiColor && isRoot(nei,node)) continue;
            
    //         isNotPossible[node] = true;

    //         return false;
    //     }

    //     return true;
    // }

    public int findColoredRoot(int[][] edges, String colors) {
        final int n = edges.length + 1;
        // this.isNotPossible = new boolean[n];
        this.colors = colors;

        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for(int i = 0 ; i < n ; i++){
            // if(isNotPossible[i]) continue;

            if(isRoot(i,-1)) return i;
        }

        return -1;
    }
}