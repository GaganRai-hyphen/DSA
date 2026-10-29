class Solution {
    public int minCost(int[][] grid) {
       int m = grid.length;
        int n = grid[0].length;
        boolean[][] dp = new boolean[n][1024];
        
        for (int i = 0; i < m; i++) {
            boolean[][] nextDp = new boolean[n][1024];
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                if (i == 0 && j == 0) {
                    nextDp[j][val] = true;
                } else {
                    if (i > 0) {
                        for (int k = 0; k < 1024; k++) {
                            if (dp[j][k]) {
                                nextDp[j][k ^ val] = true;
                            }
                        }
                    }
                    if (j > 0) {
                        for (int k = 0; k < 1024; k++) {
                            if (nextDp[j - 1][k]) {
                                nextDp[j][k ^ val] = true;
                            }
                        }
                    }
                }
            }
            dp = nextDp;
        }
        
        for (int k = 0; k < 1024; k++) {
            if (dp[n - 1][k]) {
                return k;
            }
        }
        
        return -1;
        
    }
}