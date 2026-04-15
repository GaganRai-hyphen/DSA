// Last updated: 4/15/2026, 3:40:32 PM
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long totalSum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += grid[i][j];
            }
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        long target = totalSum / 2;
        long runningSum = 0;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                runningSum += grid[i][j];
            }
            if (runningSum == target) {
                return true;
            }
        }

        runningSum = 0;

        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                runningSum += grid[i][j];
            }
            if (runningSum == target) {
                return true;
            }
        }

        return false;
    }
}