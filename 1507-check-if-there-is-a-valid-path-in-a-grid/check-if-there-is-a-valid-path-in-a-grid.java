class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        
        int[][][] moves = {
            {},
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}},
            {{0, -1}, {-1, 0}},
            {{0, 1}, {-1, 0}}
        };
        
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            
            for (int[] move : moves[grid[x][y]]) {
                int nx = x + move[0];
                int ny = y + move[1];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    for (int[] nextMove : moves[grid[nx][ny]]) {
                        if (nx + nextMove[0] == x && ny + nextMove[1] == y) {
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                            break;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}