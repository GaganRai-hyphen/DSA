// Last updated: 4/15/2026, 3:40:42 PM
class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = -1000000000;
                dp[i][j][1] = -1000000000;
                dp[i][j][2] = -1000000000;
            }
        }
        
        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                
                for (int k = 0; k < 3; k++) {
                    int val = -1000000000;
                    
                    if (i > 0) {
                        val = Math.max(val, dp[i - 1][j][k] + coins[i][j]);
                        if (k > 0 && coins[i][j] < 0) {
                            val = Math.max(val, dp[i - 1][j][k - 1]);
                        }
                    }
                    
                    if (j > 0) {
                        val = Math.max(val, dp[i][j - 1][k] + coins[i][j]);
                        if (k > 0 && coins[i][j] < 0) {
                            val = Math.max(val, dp[i][j - 1][k - 1]);
                        }
                    }
                    
                    dp[i][j][k] = val;
                }
            }
        }
        
        return Math.max(dp[m - 1][n - 1][0], Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
        
    }
}