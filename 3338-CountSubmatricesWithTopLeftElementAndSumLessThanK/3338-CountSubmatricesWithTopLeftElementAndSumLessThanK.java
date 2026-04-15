// Last updated: 4/15/2026, 3:40:53 PM
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int maxCol = n;
        
        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            for (int j = 0; j < maxCol; j++) {
                rowSum += grid[i][j];
                if (i > 0) {
                    grid[i][j] = rowSum + grid[i - 1][j];
                } else {
                    grid[i][j] = rowSum;
                }
                
                if (grid[i][j] <= k) {
                    count++;
                } else {
                    maxCol = j;
                    break;
                }
            }
        }
        
        return count;
        
    }
}