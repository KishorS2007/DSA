import java.util.*;
class Solution {
    private class Box{
        int node;
        double probability;

        public Box(int node , double probability){
            this.node = node;
            this.probability = probability;
        }
    }
    List<List<int[]>> adj = new ArrayList<>();
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double ans = 0;
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i < edges.length ; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1],i});
            adj.get(edges[i][1]).add(new int[]{edges[i][0],i});
        }

        double[] dist = new double[n]; 
        PriorityQueue<Box> q = new PriorityQueue<>((a,b)->Double.compare(b.probability , a.probability));
        q.offer(new Box(start_node,1));

        while(!q.isEmpty()){
            Box curr = q.poll();
            if(curr.node == end_node) return curr.probability;

            for(int[] nei : adj.get(curr.node)){
                double newProbability = curr.probability * succProb[nei[1]];

                if(dist[nei[0]] >= newProbability) continue;
                dist[nei[0]] = newProbability;

                q.offer(new Box(nei[0] , newProbability));
            }
        }

        return 0;
    }
}