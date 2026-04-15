// Last updated: 4/15/2026, 3:40:49 PM
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] countX = new int[m + 1][n + 1];
        int[][] countY = new int[m + 1][n + 1];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                countX[i + 1][j + 1] = countX[i][j + 1] + countX[i + 1][j] - countX[i][j] + (grid[i][j] == 'X' ? 1 : 0);
                countY[i + 1][j + 1] = countY[i][j + 1] + countY[i + 1][j] - countY[i][j] + (grid[i][j] == 'Y' ? 1 : 0);

                if (countX[i + 1][j + 1] > 0 && countX[i + 1][j + 1] == countY[i + 1][j + 1]) {
                    result++;
                }
            }
        }

        return result;
        
    }
}