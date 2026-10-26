class Solution {
    int[][] grid;
    boolean[][] visited;
    int n , m;
    private static int[][] directions = {
        {-1,0} , {0,1} , {1,0} , {0,-1}
    };

    private long solve(int i , int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j] = true;

        long sum = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            sum += grid[curr[0]][curr[1]];

            for(int[] d : directions){
                int x = d[0] + curr[0] , y = d[1] + curr[1];

                if(x < 0 || x == n || y < 0 || y == m || visited[x][y] || grid[x][y] == 0) continue;

                visited[x][y] = true;
                q.offer(new int[]{x,y});
            }
        }

        return sum;
    }

    public int countIslands(int[][] grid, int k) {
        n = grid.length ;
        m = grid[0].length;
        visited = new boolean[n][m];
        this.grid = grid;

        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && grid[i][j] != 0 && solve(i,j) % k == 0) count++;
            }
        }

        return count;
    }
}