import java.util.*;
class Solution {
    private static int[][] dir = {
        {0,1} , {1,0}
    };

    public int minCost(int[][] grid) {
        final int m = grid.length , n = grid[0].length;
        int minCost = 1024;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,grid[0][0]});

        boolean[][][] dp = new boolean[m][n][1024];

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0] , j = curr[1] , cost = curr[2];
            
            if(i == m - 1 && j == n-1){
                minCost = Math.min(minCost,cost);
            }

            for(int[] d : dir){
                int x = d[0] + i , y = d[1] + j;

                if(x < 0 || x == m || y < 0 || y == n) continue;
                
                int newCost = cost ^ grid[x][y];
                if(dp[x][y][newCost]) continue;

                dp[x][y][newCost] = true;
                q.offer(new int[]{x,y,newCost});
            }
        }

        return minCost;
    }
}