// Last updated: 4/15/2026, 3:42:40 PM
class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int[][] dp = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = 3001;
            }
        }

        for (int i = 1; i < n; i++) {
            int curr = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';
            
            for (int other = 0; other < 26; other++) {
                if (dp[i - 1][other] == 3001 && i > 1) continue;
                
                int baseDist = (i == 1) ? 0 : dp[i - 1][other];

                dp[i][other] = Math.min(dp[i][other], baseDist + getDist(prev, curr));

                dp[i][prev] = Math.min(dp[i][prev], baseDist + (i == 1 ? 0 : getDist(other, curr)));
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int j = 0; j < 26; j++) {
            minDistance = Math.min(minDistance, dp[n - 1][j]);
        }
        return minDistance;
    }

    private int getDist(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
        
    }
}