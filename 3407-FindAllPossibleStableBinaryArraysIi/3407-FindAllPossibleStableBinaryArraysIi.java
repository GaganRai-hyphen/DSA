// Last updated: 4/15/2026, 3:40:51 PM
class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1000000007;
        
        long[][][] dp = new long[zero + 1][one + 1][2];

        // Base Case 1: Agar array mein sirf '0' hain
        // Hum sirf wahan tak 0 rakh sakte hain jahan tak 'limit' allow kare
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1; 
        }

        // Base Case 2: Agar array mein sirf '1' hain
        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }

        // Main DP Transitions
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                
                // --- STATE 1: Array ends with 0 ---
                // Naya 0 lagane ke liye, pichla array ya toh 0 par end ho sakta hai ya 1 par
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                
                // INCLUSION-EXCLUSION: Agar lagatar 0s limit cross kar gaye hain
                if (i > limit) {
                    // Hum wo cases minus karenge jahan exactly (limit + 1) zeros ek saath aa gaye
                    dp[i][j][0] = (dp[i][j][0] - dp[i - limit - 1][j][1] + MOD) % MOD;
                }

                // --- STATE 2: Array ends with 1 ---
                // Naya 1 lagane ke liye, pichla array ya toh 0 par end ho sakta hai ya 1 par
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                
                // INCLUSION-EXCLUSION: Agar lagatar 1s limit cross kar gaye hain
                if (j > limit) {
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j - limit - 1][0] + MOD) % MOD;
                }
            }
        }

        long ans = (dp[zero][one][0] + dp[zero][one][1]) % MOD;
        return (int) ans;
    }
}