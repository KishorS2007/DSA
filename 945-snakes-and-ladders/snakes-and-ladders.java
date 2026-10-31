import java.util.*;
class Solution {
    public int snakesAndLadders(int[][] board) {
        final int n = board.length;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        
        int[] minRolls = new int[n * n + 1];
        Arrays.fill(minRolls,-1);
        minRolls[1] = 0;

        while(!q.isEmpty()){
            int box = q.poll();

            for(int i = 1; i <= 6 && box + i <= n * n ; i++){
                int next = box + i;
                int row = (next - 1) / n;
                int col = (next - 1) % n;

                int val = board[n-row-1][row % 2 == 1? n-col-1 : col];
                if(val != -1) next = val;

                if(minRolls[next] != -1) continue;
                minRolls[next] = minRolls[box] + 1;

                if(next == n * n) return minRolls[next];
                
                q.offer(next);
                
            }
        }

        return -1;
    }
}