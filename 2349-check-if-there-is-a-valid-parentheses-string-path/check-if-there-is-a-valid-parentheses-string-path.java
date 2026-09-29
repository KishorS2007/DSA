class Solution {
    char[][] grid;
    int[][][] dp; // valid [1 = > possible , -1 => not possible]
    int n , m;
    public boolean hasValidPath(char[][] grid) {
        if(grid[0][0] == ')' || grid[grid.length-1][grid[0].length-1] == '(')
            return false;
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        
        if((m + n - 1) % 2 == 1) return false;
        
        dp = new int[n][m][m + n];

        return dfs(0,0,1) == 1;
    }

    private int dfs(int i , int j , int open){
        if(open < 0) return -1;
        if(dp[i][j][open] != 0) return dp[i][j][open];
        if(i == grid.length - 1 && j == grid[0].length - 1){
            return dp[i][j][open] = open == 0 ? 1 : -1;
        }

        int bottom = 0 , right = 0;
        if(i+1 != n){
            bottom = dfs(i+1 , j , open + (grid[i+1][j] == ')' ? -1 : 1));
            if(bottom == 1) return dp[i][j][open] = bottom;
        }

        if(j+1 != m){
            right = dfs(i , j+1 , open + (grid[i][j+1] == ')' ? -1 : 1));
            if(right == 1) return dp[i][j][open] = right;
        }

        return dp[i][j][open] = -1;
    }
}
/* import java.util.*;
class Solution {
    public boolean hasValidPath(char[][] grid) {
        if(grid[0][0] == ')' || grid[grid.length-1][grid[0].length-1] == '(')
            return false;

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0] , j = curr[1] , open = curr[2];

            if(i == n-1 && j == m-1){
                if(open == 0) return true;
                continue;
            }

            // bottom
            if(i+1 != n){
                int newOpen = grid[i+1][j] == '(' ? 1 : -1;
                q.offer(new int[]{i+1 , j , open + newOpen});
            }

            // right
            if(j+1 != m){
                int newOpen = grid[i][j+1] == '(' ? 1 : -1;
                q.offer(new int[]{i , j+1 , open + newOpen});
            }
        }

        return false;
    }
} */