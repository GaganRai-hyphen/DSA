class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] prevRow = new int[n][k + 1];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(prevRow[i], -1);
        }
        
        for (int i = 0; i < m; i++) {
            int[][] currRow = new int[n][k + 1];
            for (int j = 0; j < n; j++) {
                Arrays.fill(currRow[j], -1);
                
                if (i == 0 && j == 0) {
                    currRow[0][0] = 0;
                    continue;
                }
                
                int cst = grid[i][j] > 0 ? 1 : 0;
                for (int c = cst; c <= k; c++) {
                    int max = -1;
                    if (i > 0 && prevRow[j][c - cst] != -1) {
                        max = Math.max(max, prevRow[j][c - cst] + grid[i][j]);
                    }
                    if (j > 0 && currRow[j - 1][c - cst] != -1) {
                        max = Math.max(max, currRow[j - 1][c - cst] + grid[i][j]);
                    }
                    currRow[j][c] = max;
                }
            }
            prevRow = currRow;
        }
        
        int ans = -1;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, prevRow[n - 1][c]);
        }
        return ans;
    }
}