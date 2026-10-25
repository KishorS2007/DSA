class Solution {
    int[][] grid;
    boolean[][] visited;
    int n , m;
    private static int[][] directions = {
        {-1,0} , {0,1} , {1,0} , {0,-1}
    };

    private boolean isValidIsland(int i , int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j] = true;

        boolean isValidIsland = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[0] == 0 || curr[0] == n-1 || curr[1] == 0 || curr[1] == m-1) isValidIsland = false;
            for(int[] d : directions){
                int x = d[0] + curr[0] , y = d[1] + curr[1];

                if(x < 0 || x == n || y < 0 || y == m || visited[x][y] || grid[x][y] == 1) continue;

                visited[x][y] = true;
                q.offer(new int[]{x,y});
            }
        }

        return isValidIsland;
    }

    public int closedIsland(int[][] grid) {
        n = grid.length ;
        m = grid[0].length;
        visited = new boolean[n][m];
        this.grid = grid;

        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && grid[i][j] == 0 && isValidIsland(i,j)) count++;
            }
        }

        return count;
    }

}