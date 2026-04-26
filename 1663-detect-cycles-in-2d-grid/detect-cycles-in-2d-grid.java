class Solution {
    
    int[] dRow = {0, 1, 0, -1};
    int[] dCol = {1, 0, -1, 0};

    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int r, int c, int parentR, int parentC, char targetChar) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dRow[i];
            int nextC = c + dCol[i];

            if (nextR >= 0 && nextR < grid.length && nextC >= 0 && nextC < grid[0].length) {
                if (grid[nextR][nextC] == targetChar) {
                    if (!visited[nextR][nextC]) {
                        if (dfs(grid, visited, nextR, nextC, r, c, targetChar)) {
                            return true;
                        }
                    } else if (nextR != parentR || nextC != parentC) {
                        return true; 
                    }
                }
            }
        }
        
        return false;
    }
}