// Last updated: 4/15/2026, 3:42:18 PM
class Solution {
    public int concatenatedBinary(int n) {
        long ans = 0;
        int length = 0;
        int MOD = 1_000_000_007;
        
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                length++;
            }
            ans = ((ans << length) | i) % MOD;
        }
        
        return (int) ans;
        
    }
}