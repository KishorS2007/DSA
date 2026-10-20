class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        Map<Character,int[]> directions = Map.ofEntries(
            Map.entry('L',new int[]{0,-1}),
            Map.entry('R',new int[]{0,1}),
            Map.entry('U',new int[]{-1,0}),
            Map.entry('D',new int[]{1,0})
        );

        final int n = grid.length , m = grid[0].length;
        int x = 0 , y = 0;

        while(true){
            char move = grid[x][y];
            int[] dir = directions.get(move);

            int newX = x + dir[0] , newY = y + dir[1];
            if(newX < 0 || newX == n || newY < 0 || newY == m) break;
            if(grid[newX][newY] == 'X') break; // 'x' => visited
            
            grid[x][y] = 'X'; // mark visited
            x = newX;
            y = newY;
        }

        return new int[]{x,y};
    }
}